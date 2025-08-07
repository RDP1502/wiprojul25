package com.wipro.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping
	public String save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody User user) {
		return userService.update(id,  user);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return userService.delete(id);
	}

	
	
}
