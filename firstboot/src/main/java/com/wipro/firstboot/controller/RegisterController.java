package com.wipro.firstboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.firstboot.model1.User;


@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@GetMapping("/login")
	String showLoginForm(Model m)
	{
		return "login";
	}
	
	
	@PostMapping("/testsubmit")
	String submitTestLoginForm(@ModelAttribute("logindata") User user,Model m)
	{
		 System.out.println("Test Submit");
		 System.out.println();
		return "usersuccess";
	}


}