package com.wipro.mvcdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mvcdemo.repo.CarRepo;
import com.wipro.mvcdemo.service.CarService;
@Service
public class CarServiceImpl implements CarService{
	
		@Autowired
		CarRepo carRepo;

	@Override
	public List<String> getCarList() {
		// TODO Auto-generated method stub
		return carRepo.getCarList();
	}
}
