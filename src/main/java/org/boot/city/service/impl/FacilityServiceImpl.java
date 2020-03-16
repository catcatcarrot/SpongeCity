package org.boot.city.service.impl;

import java.util.Date;
import java.util.List;

import org.boot.city.entity.Facility;
import org.boot.city.entity.FacilityTable;
import org.boot.city.mapper.FacilityMapper;
import org.boot.city.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	private FacilityMapper facilityMapper;

	@Override
	public List<Facility> getFacility(Integer status) {
		return facilityMapper.getFacility(status);
	}
	
	
	@Override
	public int insertFacility(FacilityTable facilityTable) {
		return facilityMapper.insertFacility(facilityTable);
	}

	@Override
	public int updateOutFacility(Integer number) {
		//±®∑œ ±º‰
		Date date = new Date();
		return facilityMapper.updateOutFacility(number,date);
	}


	@Override
	public List<Facility> searchFacility(Integer number, Integer status) {
		return facilityMapper.searchFacility(number, status);
	}


}
