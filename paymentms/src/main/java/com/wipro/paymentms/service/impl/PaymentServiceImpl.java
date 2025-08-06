package com.wipro.paymentms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.paymentms.entity.Payment;
import com.wipro.paymentms.repo.PaymentRepo;
import com.wipro.paymentms.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepo paymentRepo;

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
		// TODO Auto-generated method stub
		paymentRepo.deleteById(id);
		
	}

	@Override
	public Payment findById(int id) {
		// TODO Auto-generated method stub
		return paymentRepo.findById(id).get();
	}

	@Override
	public Payment findByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return paymentRepo.findByOrderId(orderId);
	}
	
	

}
