package com.wipro.orderms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.orderms.entity.Cart;

public interface CartService {
	
	ResponseEntity save(Cart cart);
	List<Cart> findAll();
	List<Cart> findByUserId(int userId);
	Cart findById(int id);
	ResponseEntity update(int id,Cart cart);
	ResponseEntity delete(int id);
	
}
