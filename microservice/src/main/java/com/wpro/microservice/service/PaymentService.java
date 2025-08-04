package com.wpro.microservice.service;

import java.util.List;

import com.wpro.microservice.entity.Payment;

public interface PaymentService {
	
	void save(Payment payment);
	List<Payment> findAll();
	
	void delete(int id);
	

}
