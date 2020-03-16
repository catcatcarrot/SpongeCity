package org.boot.city.controller;

import java.util.List;

import org.boot.city.entity.Region;
import org.boot.city.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping("/getAllRegion")
	@ResponseBody
	public List<Region> getAllRegion(){
		return regionService.getAllRegion();
	}

}
