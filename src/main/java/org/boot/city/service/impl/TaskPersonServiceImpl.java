package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.TaskPerson;
import org.boot.city.mapper.TaskPersonMapper;
import org.boot.city.service.TaskPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskPersonServiceImpl implements TaskPersonService{
	
	@Autowired
	private TaskPersonMapper taskPersonMapper;

	@Override
	public List<TaskPerson> getAllTaskPerson() {
		return taskPersonMapper.getAllTaskPerson();
	}

}
