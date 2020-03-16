package org.boot.city.controller;

import java.util.List;

import org.boot.city.entity.Msg;
import org.boot.city.entity.Task;
import org.boot.city.entity.TaskPerson;
import org.boot.city.mapper.TaskMapper;
import org.boot.city.service.TaskPersonService;
import org.boot.city.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TaskController {
	private static int i;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskPersonService taskPersonService;
	
	@RequestMapping("/getTask")
	@ResponseBody
	public Msg getAllTask(@RequestParam(defaultValue="1")Integer page,Integer limit) {
		PageHelper.startPage(page, limit);
		List<Task> list = taskService.getAllTask();	
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		
		i=limit*(pageInfo.getPageNum()-1)+1;
		for(Task task:list) {
			task.setId(i++);
		}
		
		long total = pageInfo.getTotal();
		
		Msg msg = new Msg();
		if(list.size()==0) {
			msg.setCode(1);
			msg.setMsg("无数据");
		}else {
			msg.setCode(0);
			msg.setMsg("处理成功");
		}
		msg.setData(list);
		msg.setCount(total);
		return msg;
	}
	
	@RequestMapping("getAllTaskPerson")
	@ResponseBody
	public Msg getAllTaskPerson(Integer page,Integer limit) {
		PageHelper.startPage(page, limit);
		List<TaskPerson> list = taskPersonService.getAllTaskPerson();
		PageInfo<TaskPerson> pageInfo = new PageInfo<>(list);
		i=limit*(pageInfo.getPageNum()-1)+1;
		for(TaskPerson task:list) {
			task.setId(i++);
		}
		
		long total = pageInfo.getTotal();
		
		Msg msg = new Msg();
		if(list.size()==0) {
			msg.setCode(1);
			msg.setMsg("无数据");
		}else {
			msg.setCode(0);
			msg.setMsg("处理成功");
		}
		msg.setData(list);
		msg.setCount(total);
		return msg;
	}
	
	@RequestMapping("/getTasksByDealStatus")
	@ResponseBody
	public Msg getTasksByDealStatus(@RequestParam(value="page",defaultValue="1")Integer page,
			Integer limit,String dealStatus) {
		PageHelper.startPage(page, limit);
		List<Task> list = taskService.getTasksByDealStatus(dealStatus);
		
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		
		i=limit*(pageInfo.getPageNum()-1)+1;
		for(Task task:list) {
			task.setId(i++);
		}
		
		long total = pageInfo.getTotal();
		
		Msg msg = new Msg();
		if(list.size()==0) {
			msg.setCode(1);
			msg.setMsg("无数据");
		}else {
			msg.setCode(0);
			msg.setMsg("处理成功");
		}
		msg.setData(list);
		msg.setCount(total);
		return msg;
	}
	
	@RequestMapping("/updateTasksByDealStatus")
	@ResponseBody
	public Msg updateTasksByDealStatus(Integer id,String dealStatus) {
		int result =taskService.updateTasksByDealStatus(id, dealStatus);
		if(result==1) {
			return Msg.success();
		}else if(result==-1) {
			Msg msg = new Msg();
			msg.setCode(-1);
			return msg;
		}else {
			return Msg.fail();
		}
	}

}
