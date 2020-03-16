package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.Level;
import org.boot.city.mapper.LevelMapper;
import org.boot.city.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	private LevelMapper levelMapper;

	@Override
	public List<Level> getAllLevel() {
		return levelMapper.getAllLevel();
	}

}
