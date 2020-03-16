package org.boot.city.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.boot.city.entity.People;
import org.boot.city.entity.Task;
import org.boot.city.mapper.PeopleMapper;
import org.boot.city.mapper.TaskMapper;
import org.boot.city.mapper.TaskPersonMapper;
import org.boot.city.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private PeopleMapper peopleMapper;
	
	@Autowired
	private TaskPersonMapper taskPersonMapper;

	@Override
	public List<Task> getAllTask() {
		return taskMapper.getTasks();
	}

	@Override
	public List<Task> getTasksByDealStatus(String dealStatus) {
		return taskMapper.getTasksByDealStatus(dealStatus);
	}

	@Override
	@Transactional
	public int updateTasksByDealStatus(Integer id, String dealStatus) {
		if(dealStatus.equals("待分配")) {
			Date date = new Date();
			return taskMapper.updateTasksByDealStatus(id, dealStatus,date);
		}else {
			//'已分配' ---  为任务分配运维人员
			//返回-1说明该片区没有运维人员
			int value=assignPersonForTask(id);
			
			if(value==1) {
				return taskMapper.updateTasksByDealStatus(id, dealStatus,null);
			}
			return value;
		}
		
	}
	
	//分配规则  运维人员>决策层    分配任务少的先分配
	public int assignPersonForTask(Integer id) {
		//得到分配任务的region
		int region = taskMapper.getRegionByTask(id);
		//处理该region的运维人员(包括决策层)
		List<People> list = peopleMapper.getPeopleByRegion(region);
		//每个运维人员所处理的task数量
		HashMap<People,Integer> map = new HashMap<>();
		for(People p:list) {
			int count =taskPersonMapper.getCountByPersonId(p.getId());
			map.put(p, count);
		}
		
		int i=0;
		int j=0;
		for(People p:map.keySet()) {
			if(p.getLevelName().equals("运维人员")) {
				i++;
			}else {
				j++;
			}
		}
		
		AssignPerson[] aps1 = new AssignPerson[i];
		AssignPerson[] aps2 = new AssignPerson[j];
		i=0;
		j=0;
		for(People p:map.keySet()) {
			if(p.getLevelName().equals("运维人员")) {
				aps1[i] = new AssignPerson();
				aps1[i].setpId(p.getId());
				aps1[i].setCount(map.get(p));
				i++;
			}else {
				aps2[j] = new AssignPerson();
				aps2[j].setpId(p.getId());
				aps2[j].setCount(map.get(p));
				j++;
			}
		}
		
		Arrays.sort(aps1);
		Arrays.sort(aps2);
			
		int pid;
		if(aps1.length!=0) {
			pid = aps1[0].getpId();
		}else if(aps2.length!=0) {
			pid = aps2[0].getpId();
		}else {
			return -1;
		}
		
		int result = taskPersonMapper.insertTaskPerson(id, pid);
		return result;
	}
	
	class AssignPerson implements Comparable<AssignPerson>{
		private int pId;
		private int count;
		
		public int getpId() {
			return pId;
		}
		public void setpId(int pId) {
			this.pId = pId;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public int compareTo(AssignPerson o) {
			if(this.count<o.count)
				return -1; //谁的count小谁在前面
			else if(this.count>o.count)
				return 1;
			return 0;
		}
		
	}

	

}
