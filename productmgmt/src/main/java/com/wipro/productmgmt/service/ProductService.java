package com.wipro.productmgmt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.productmgmt.entity.ProductMgmt;

public interface ProductService {
	
	void save(ProductMgmt productMgmt);
	List<ProductMgmt> findAll();
	ProductMgmt findById(int id);
	void deleteById(int id);
	List<ProductMgmt> findByProductName(String productName);
	List<ProductMgmt> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);
	Page<ProductMgmt> findAll(Pageable p);


}
