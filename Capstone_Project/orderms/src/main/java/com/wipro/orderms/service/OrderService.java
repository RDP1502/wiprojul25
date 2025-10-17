package com.wipro.orderms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.orderms.entity.Orders;

public interface OrderService {
	
	ResponseEntity save(Orders orders);
	List<Orders> findAll();
	Orders findById(int id);
	ResponseEntity update(int orderId, Orders orders);
	ResponseEntity delete(int id);
	List<Orders> findByUserId(int userId);
	
}
