package org.boot.city.controller;

import java.util.ArrayList;
import java.util.List;

import org.boot.city.entity.Msg;
import org.boot.city.entity.People;
import org.boot.city.entity.PeopleTable;
import org.boot.city.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PeopleController {
	private static int i;
	
	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping("/getAllPeople")
	@ResponseBody
	public Msg getAllPeople(@RequestParam(defaultValue="1") Integer page,Integer limit) {
		PageHelper.startPage(page, limit);
		List<People> list = peopleService.getAllPeople();
		PageInfo<People> pageInfo = new PageInfo<>(list);
		
		i=limit*(pageInfo.getPageNum()-1)+1;
		for(People people:list) {
			people.setId(i++);
		}
		
		long total = pageInfo.getTotal();
		
		Msg msg = new Msg();
		
		if(list.size()==0) {
			msg.setCode(1);
			msg.setMsg("������");
		}else {
			msg.setCode(0);
			msg.setMsg("����ɹ�");
		}
		msg.setData(list);
		msg.setCount(total);
		return msg;
	}
	
	@RequestMapping("/searchPeopleByNum")
	@ResponseBody
	public Msg searchPeopleByNum(Integer page,Integer limit,
			@RequestParam("peopleNum")String peopleNum1) {
		if(peopleNum1==null || peopleNum1.trim().equals("")) {
			return getAllPeople(page, limit);
		}
		
		List<People> list = peopleService.getAllPeople();
		List<People> search = new ArrayList<People>();
		
		int i=1;
		for(People p:list) {
			p.setId(i++);
			if(p.getNumber().equals(peopleNum1.trim())) {
				search.add(p);
			}
		}
		
		Msg msg = new Msg();
		
		if(search.size()==0) {
			msg.setCode(1);
			msg.setMsg("������");
		}else {
			msg.setCode(0);
			msg.setMsg("����ɹ�");
		}
		msg.setData(search);
		msg.setCount(search.size());
		return msg;
	}
	
	@RequestMapping("/insertPeople")
	@ResponseBody
	public Msg insertPeople(PeopleTable people) {
		int result = peopleService.insertPeople(people);
		
		Msg msg = new Msg();
		if(result==1) {
			msg.setCode(0);
			msg.setMsg("��ӳɹ�");
		}else {
			msg.setCode(1);
			msg.setMsg("���ʧ��");
		}
		return msg;
	}
	
	
	@RequestMapping("/deletePeopleByNum")
	@ResponseBody
	//@PreAuthorize("hasRole('ROLE_ADMIN_HIGH')")
	public Msg deletePeopleByNum(String number) {
		System.out.println(number);
		int result = peopleService.deletePeopleByNum(number);
		
		Msg msg = new Msg();
		if(result==1) {
			msg.setCode(0);
			msg.setMsg("ɾ���ɹ�");
		}else {
			msg.setCode(1);
			msg.setMsg("ɾ��ʧ��");
		}
		
		return msg;
	}

}
