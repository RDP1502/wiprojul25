package com.tcs.entity.relationdemo.service;

import java.util.List;

import com.tcs.entity.relationdemo.entity.Employee;

public interface EmployeeService {
	
	void save(Employee employee);
	List<Employee> findAll();

}
