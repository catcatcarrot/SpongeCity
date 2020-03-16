package org.boot.city.service;

import java.util.List;

import org.boot.city.entity.Facility;
import org.boot.city.entity.FacilityTable;

public interface FacilityService {
	
	List<Facility> getFacility(Integer status);
	
	int insertFacility(FacilityTable facilityTable);
	
	int updateOutFacility(Integer number);
	
	List<Facility> searchFacility(Integer number, Integer status);

}
