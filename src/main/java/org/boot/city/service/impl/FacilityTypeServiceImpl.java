package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.FacilityType;
import org.boot.city.mapper.FacilityTypeMapper;
import org.boot.city.service.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService{
	
	@Autowired
	private FacilityTypeMapper facilityTypeMapper;

	@Override
	public List<FacilityType> getAllFacilityType() {
		return facilityTypeMapper.getAllFacilityType();
	}
	
}
