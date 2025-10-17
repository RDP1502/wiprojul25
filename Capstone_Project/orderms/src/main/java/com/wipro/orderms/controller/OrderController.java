package com.wipro.orderms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.orderms.entity.Orders;
import com.wipro.orderms.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/place")
	public ResponseEntity newOrder(@RequestBody Orders orders) {
		return orderService.save(orders);
	}
	
	@GetMapping
	public List<Orders> findAll(){
		return orderService.findAll();
	}
	
	@GetMapping("/{id}")
	public Orders findById(@PathVariable int id) {
		return orderService.findById(id);
	}
	
	@GetMapping("/userId/{userId}")
	public List<Orders> findByUserId(@PathVariable int userId){
		return orderService.findByUserId(userId);
	}
	
	@PutMapping("/place/{id}")
	public ResponseEntity update(@PathVariable int id, @RequestBody Orders order) {
		
		return orderService.update(id, order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		return orderService.delete(id);
	}

}
