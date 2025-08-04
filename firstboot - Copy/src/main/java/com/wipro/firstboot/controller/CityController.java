package com.wipro.firstboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.firstboot.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/list")
	String getCityList(Model m) {
		m.addAttribute("citylist", cityService.getCityList());
		return "citylist";
	}

}
