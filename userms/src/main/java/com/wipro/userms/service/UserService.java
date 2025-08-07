package com.wipro.userms.service;

import java.util.List;

import com.wipro.userms.entity.User;

public interface UserService {
	
	String save(User user);
	List<User> findAll();
	String update(int id, User user);
	String delete(int  id);
	

}
