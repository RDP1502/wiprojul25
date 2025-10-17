package com.wipro.orderms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.orderms.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	
	
}
