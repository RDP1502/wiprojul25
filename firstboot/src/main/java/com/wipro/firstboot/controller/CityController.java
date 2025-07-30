package com.wipro.firstboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.firstboot.service.CitiesService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	CitiesService cityService;
	
	@GetMapping("/list")
	String getCitiesList(Model m)
	{
		
		m.addAttribute("citylist", cityService.getCitiesList());
		return "citylist";
	}
	

}
