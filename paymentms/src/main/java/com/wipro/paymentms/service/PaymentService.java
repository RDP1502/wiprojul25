package com.wipro.paymentms.service;

import java.util.List;

import com.wipro.paymentms.entity.Payment;

public interface PaymentService {
	void save(Payment payment);
	List<Payment> findAll();
	void delete(int id);
	Payment findById(int id);
	Payment findByOrderId(int orderId);
}
