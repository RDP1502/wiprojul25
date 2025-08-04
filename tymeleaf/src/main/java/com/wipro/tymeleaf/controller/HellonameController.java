package com.wipro.tymeleaf.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HellonameController {
	
	@GetMapping("/hello")
	String showWelcome(Model m)
	{
		m.addAttribute("name", "Rohan");
		return "index";		
	}

}
