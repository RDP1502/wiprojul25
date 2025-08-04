package com.wipro.productmgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.productmgmt.entity.ProductMgmt;
import com.wipro.productmgmt.repo.ProductRepo;
import com.wipro.productmgmt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public void save(ProductMgmt productMgmt) {
		// TODO Auto-generated method stub
		productRepo.save(productMgmt);
		
	}

	@Override
	public List<ProductMgmt> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public ProductMgmt findById(int id) {
		// TODO Auto-generated method stub
		Optional<ProductMgmt> productMgmt = productRepo.findById(id);
		if(!productMgmt.isEmpty()) {
			return productMgmt.get();
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

	@Override
	public List<ProductMgmt> findByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepo.findByProductName(productName);
	}

	@Override
	public List<ProductMgmt> findByProductNameAndProductMakeOrderByProductNameDesc(String productName,
			String productMake) {
		// TODO Auto-generated method stub
		return productRepo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}

	@Override
	public Page<ProductMgmt> findAll(Pageable p) {
		// TODO Auto-generated method stub
		return productRepo.findAll(p);
	}
	
	
	

}
