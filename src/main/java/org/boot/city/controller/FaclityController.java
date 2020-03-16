package org.boot.city.controller;

import java.util.ArrayList;
import java.util.List;

import org.boot.city.entity.Facility;
import org.boot.city.entity.FacilityTable;
import org.boot.city.entity.Msg;
import org.boot.city.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class FaclityController {
	private static int i;
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping("/getFacility")
	@ResponseBody
	public Msg getFacility(@RequestParam(defaultValue="1") Integer page,
			Integer limit,Integer status) {
		
		PageHelper.startPage(page, limit);
		List<Facility> list = facilityService.getFacility(status);
		
		i=limit*(page-1)+1;
		for(Facility facility:list) {
			facility.setId(i++);
		}
		
		PageInfo<Facility> pageInfo = new PageInfo<>(list);
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
	
	@RequestMapping("/insertFacility")
	@ResponseBody
	public Msg insertFacility(FacilityTable facilityTable) {
		//0--设施入库   1--设施使用
		Msg msg = new Msg();
		int result=facilityService.insertFacility(facilityTable);
		if(result==1) {
			msg.setCode(0);
			msg.setMsg("添加成功");
		}else {
			msg.setCode(1);
			msg.setMsg("添加失败");
		}
		return msg;
	}
	
	@RequestMapping("/updateOutFacility")
	@ResponseBody
	public Msg updateOutFacility(@RequestParam("num")Integer number) {
		int result =facilityService.updateOutFacility(number);
		Msg msg = new Msg();
		if(result==1) {
			msg.setCode(0);
			msg.setMsg("报废成功");
		}else {
			msg.setCode(1);
			msg.setMsg("报废失败");
		}
		return msg;
	}
	
	@RequestMapping("/searchFacility")
	@ResponseBody
	public Msg searchFacility(Integer page,Integer limit,Integer number,
			Integer status) {
		
		if(number==null) {
			return getFacility(page, limit, status);
		}
		
		List<Facility> list =facilityService.getFacility(status);
		List<Facility> search = new ArrayList<>();
		
		int i=1;
		for(Facility f:list) {
			f.setId(i++);
			if(f.getNumber().equals(number)) {
				search.add(f);
			}
		}
	
		Msg msg = new Msg();
		
		if(search.size()==0) {
			msg.setCode(1);
			msg.setMsg("无数据");
		}else {
			msg.setCode(0);
			msg.setMsg("处理成功");
		}
		msg.setData(search);
		msg.setCount(search.size());
		return msg;
	}

}
