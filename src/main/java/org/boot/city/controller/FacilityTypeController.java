package org.boot.city.controller;

import java.util.List;

import org.boot.city.entity.FacilityType;
import org.boot.city.service.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FacilityTypeController {
	
	@Autowired
	private FacilityTypeService facilityTypeService;
	
	@RequestMapping("/getAllFacilityType")
	@ResponseBody
	public List<FacilityType> getAllFacilityType(){
		return facilityTypeService.getAllFacilityType();
	}

}
