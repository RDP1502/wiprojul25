package com.wipro.productmgmt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.productmgmt.entity.ProductMgmt;
import com.wipro.productmgmt.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	void save(@RequestBody ProductMgmt productMgmt) {
		productService.save(productMgmt);
	}
	
	@GetMapping
	List<ProductMgmt> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	ProductMgmt findById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	
	@PutMapping
	void update(@RequestBody ProductMgmt productMgmt) {
		productService.save(productMgmt);
	}
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id) {
		productService.deleteById(id);
	}
	
	
	@GetMapping("/name/{name}")
	List<ProductMgmt> findByProductName(@PathVariable String name){
		return productService.findByProductName(name);
	}
	
	@GetMapping("/filter/{productName}/{productMake}")
	List<ProductMgmt> findByProductNameAndProductMake(@PathVariable String productName, @PathVariable String productMake){
		return productService.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}
	
	@GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
	public Page<ProductMgmt> findAllPage(@PathVariable int  pageNum,@PathVariable int  pageSize,@PathVariable int  sortOrder) {
		Pageable p=null;
	  if(sortOrder==0)
	  {
		  p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").descending());
	  }
	  else
	  {
		    p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").ascending());
	  }
		
		return productService.findAll(p);
	}
	
	@GetMapping("/page")
	public Page<ProductMgmt> findAllPage1(){
		Pageable p = PageRequest.of(0, 10, Sort.by("productPrice").ascending());
		System.out.println(p.getPageSize());
		return productService.findAll(p);
	}

}
