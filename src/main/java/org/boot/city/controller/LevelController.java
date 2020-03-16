package org.boot.city.controller;

import java.util.List;

import org.boot.city.entity.Level;
import org.boot.city.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/getAllLevel")
	@ResponseBody
	public List<Level> getAllLevel(){
		return levelService.getAllLevel();
	}

}
