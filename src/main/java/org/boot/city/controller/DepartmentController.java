package org.boot.city.controller;

import java.util.List;

import org.boot.city.entity.Department;
import org.boot.city.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping("/getAllDepartment")
	@ResponseBody
	public List<Department> getAllDepartment(){
		return deptService.getAllDept();
	}

}
