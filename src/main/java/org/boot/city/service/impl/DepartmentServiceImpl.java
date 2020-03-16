package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.Department;
import org.boot.city.mapper.DepartmentMapper;
import org.boot.city.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentMapper deptMapper;

	@Override
	public List<Department> getAllDept() {
		return deptMapper.getAllDepartment();
	}

}
