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

import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.service.CartService;

@RestController
@RequestMapping("/orders/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody Cart cart) {
		return cartService.save(cart);
	}
	
	@GetMapping
	public List<Cart> findAll(){
		return cartService.findAll();
	}
	
	@GetMapping("/{id}")
	public List<Cart> findById(@PathVariable int id) {
		return cartService.findByUserId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable int id, @RequestBody Cart cart) {
		return cartService.update(id, cart);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		return cartService.delete(id);
	}
	
}
