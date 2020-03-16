package org.boot.city.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boot.city.entity.Facility;
import org.boot.city.entity.FacilityTable;

public interface FacilityMapper {
	
	List<Facility> getFacility(Integer status);
	
	int insertFacility(FacilityTable facilityTable);
	
	int updateOutFacility(@Param("number") Integer number, @Param("dumpTime") Date date);
	
	List<Facility> searchFacility(@Param("number") Integer number, @Param("status") Integer status);

}
