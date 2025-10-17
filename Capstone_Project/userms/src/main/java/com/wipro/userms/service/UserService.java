package com.wipro.userms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;

public interface UserService {
	
	List<User> findAll();
	ResponseEntity save(User user);
	User findById(int id);
	ResponseEntity update(int id, User user);
	ResponseEntity delete(int id);
	Token login(User user);
	void logout(int userId);

}
