package com.wipro.restdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.restdemo.dto.Mobile;
import com.wipro.restdemo.repo.MobileRepo;
import com.wipro.restdemo.service.MobileService;
@Service
public class MovieImpl implements MobileService{
	
	@Autowired
	MobileRepo movieRepo;

	@Override
	public void save(Mobile mobile) {
		// TODO Auto-generated method stub
		movieRepo.save(mobile);
		
	}

	@Override
	public Mobile findById(int id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id);
	}

	@Override
	public List<Mobile> findAll() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}

	@Override
	public void update(int id, Mobile mobile) {
		// TODO Auto-generated method stub
		movieRepo.update(id, mobile);
		
	}

	@Override
	public void delete(int id, Mobile mobile) {
		// TODO Auto-generated method stub
		movieRepo.delete(id, mobile);
		
	}
	
	

}
