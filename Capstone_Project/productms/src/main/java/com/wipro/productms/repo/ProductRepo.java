package com.wipro.productms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.productms.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
