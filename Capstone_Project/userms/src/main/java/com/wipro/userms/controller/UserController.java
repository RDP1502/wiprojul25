package com.wipro.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/user")
@Tag(name ="user_management", description = "Api for managing user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Operation(summary="register new user")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="user added successfully"),
		@ApiResponse(responseCode = "404", description="Invalid user details provided")
	})
	@PostMapping("/register")
	public ResponseEntity save(@RequestBody User user) {
		return userService.save(user);
		
	}
	
	@Operation(summary="List of users in that are registered")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="List of user get successfully"),
		@ApiResponse(responseCode = "403", description="Error while getting user list")
	})
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	@Operation(summary="find registered user login")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="found user loggedin successfully"),
		@ApiResponse(responseCode = "403", description="Invalid user login details")
	})
	@GetMapping("/login/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@Operation(summary="update the current user")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="user details updated successfully"),
		@ApiResponse(responseCode = "404", description="User not found")
	})
	@PutMapping("/update/{id}")
	public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user) {
		return userService.update(id, user);
	}
	
	@Operation(summary="delete the registred user")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="user deleted successfully"),
		@ApiResponse(responseCode = "404", description="user not found for delete")
	})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		return userService.delete(id);
	}
	
	@Operation(summary="your menu")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="menu of user get successfully"),
		@ApiResponse(responseCode = "404", description="Error while getting user menu")
	})
	@GetMapping("/menu/{id}") /// need clarification 
	public User userMenu(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@Operation(summary="login registred user")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="successfully logged in"),
		@ApiResponse(responseCode = "404", description="Error while login")
	})
	@PostMapping("/login")
	public Token login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@Operation(summary="logout user ")
	@ApiResponses(value={
		@ApiResponse(responseCode = "200", description="user logout successfully"),
		@ApiResponse(responseCode = "404", description="User not found")
	})
	@GetMapping("/logout/{userId}")
	public void logout(@PathVariable int userId) {
		System.out.println("user id is"+userId);
		
		userService.logout(userId);
	}

}
