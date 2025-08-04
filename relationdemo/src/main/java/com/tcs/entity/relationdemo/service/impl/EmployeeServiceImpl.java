package com.tcs.entity.relationdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.relationdemo.entity.Employee;
import com.tcs.entity.relationdemo.repo.EmployeeRepo;
import com.tcs.entity.relationdemo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.save(employee);
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	
	

}
