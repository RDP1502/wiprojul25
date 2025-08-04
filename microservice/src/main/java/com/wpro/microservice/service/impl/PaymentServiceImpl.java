package com.wpro.microservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpro.microservice.entity.Payment;
import com.wpro.microservice.repo.PaymentRepo;
import com.wpro.microservice.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepo paymentRepo;
	
	List<Payment> paymentList = new ArrayList<>();
	
	@Override
	public void save(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepo.save(payment);

	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}
	@Override
	public void delete(int id) {
	    
	    paymentRepo.deleteById(id);
	}




}
