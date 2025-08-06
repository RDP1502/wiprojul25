package com.wipro.paymentms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.paymentms.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	 Payment findByOrderId(int orderId);

}
