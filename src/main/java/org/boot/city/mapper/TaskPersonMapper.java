package org.boot.city.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boot.city.entity.TaskPerson;

public interface TaskPersonMapper {
	
	public int getCountByPersonId(Integer personId);
	
	public int insertTaskPerson(@Param("tId") Integer taskId, @Param("pId") Integer personId);

	public List<TaskPerson> getAllTaskPerson();
}
