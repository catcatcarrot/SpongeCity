package org.boot.city.service;


import java.util.List;

import org.boot.city.entity.Task;

public interface TaskService {
	
	List<Task> getAllTask();
	
	List<Task> getTasksByDealStatus(String dealStatus);
	
	int updateTasksByDealStatus(Integer id, String dealStatus);

}
