package com.wipro.productms.controller;

import java.time.LocalDate;
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

import com.wipro.productms.dto.Orders;
import com.wipro.productms.entity.Product;
import com.wipro.productms.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity saveProduct(@RequestBody Product product) {
		
		System.out.println("product is "+ product);
		return productService.save(product);
		
	}
	
	@GetMapping
	public List<Product> findAll(){
		System.out.println("inside get");
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.update(id, product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable int id) {
		return productService.delete(id);
	}
	
	@PostMapping("/place")
	public void placeOrder(@RequestBody Orders orders) {
		System.out.println("in product controller");
		productService.placeOrder(orders);
	}

}
