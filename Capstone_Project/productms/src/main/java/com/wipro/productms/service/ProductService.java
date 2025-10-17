package com.wipro.productms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.productms.dto.Orders;
import com.wipro.productms.entity.Product;

public interface ProductService {
	
	ResponseEntity save(Product product);
	List<Product> findAll();
	Product findById(int id);
	ResponseEntity update(int id, Product product);
	ResponseEntity delete(int id);
	void placeOrder(Orders orders);
	

}
