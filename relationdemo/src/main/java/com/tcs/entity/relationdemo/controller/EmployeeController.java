package com.tcs.entity.relationdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.relationdemo.entity.Employee;
import com.tcs.entity.relationdemo.service.EmployeeService;

@RestController 
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping
	void save(@RequestBody Employee employee) {
		empService.save(employee);
	}
	
	@GetMapping
	List<Employee> findAll(){
		return empService.findAll();
		}

}
