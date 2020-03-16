package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.Region;
import org.boot.city.mapper.RegionMapper;
import org.boot.city.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public List<Region> getAllRegion() {
		return regionMapper.getAllRegion();
	}

}
