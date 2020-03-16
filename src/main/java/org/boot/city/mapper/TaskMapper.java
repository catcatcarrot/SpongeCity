package org.boot.city.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boot.city.entity.Task;

public interface TaskMapper {
	
	//�ڰ����  & ��������
	List<Task> getTasks();
	
	//�õ�����״̬������
	List<Task> getTasksByDealStatus(String dealStatus);
	
	int updateTasksByDealStatus(@Param("id") Integer id,
                                @Param("dealStatus") String dealStatus, @Param("time") Date time);
	
	int getRegionByTask(Integer id);

}
