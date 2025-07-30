package com.wipro.firstboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.firstboot.repo.CitiesRepo;
import com.wipro.firstboot.service.CitiesService;

@Service
public class CityServiceImpl implements CitiesService {
	@Autowired
	CitiesRepo cityRepo;
	

	@Override
	public List<String> getCitiesList() {
		// TODO Auto-generated method stub
		return cityRepo.getCityList();
	}
}
