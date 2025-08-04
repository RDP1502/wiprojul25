package com.wipro.restdemo.service;

import java.util.List;
import com.wipro.restdemo.dto.Mobile;


public interface MobileService {
	
	
	public void save(Mobile mobile);
	public Mobile findById(int id);
	public List<Mobile> findAll();
	public void update(int id, Mobile mobile);
	public void delete(int id, Mobile mobile);

}
