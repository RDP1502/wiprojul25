package com.wpro.microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wpro.microservice.entity.Payment;
import com.wpro.microservice.repo.PaymentRepo;

public class PaymentServiceTest {
	
	@Autowired
	PaymentRepo paymentRepo;
	
	@Test
	public  void testSave(Payment payment) {
		// assertEquals(4,5+1);
		 assertEquals(payment, paymentRepo.save(payment));
	}

	
}
