package com.wpro.microservice.controller;

import org.springframework.http.HttpHeaders;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wpro.microservice.entity.Payment;
import com.wpro.microservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	HttpHeaders headers= new HttpHeaders();
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Payment payment) {
		//paymentService.save(payment);
		headers.add("created-at", LocalDate.now().toString());
		paymentService.save(payment);
		return ResponseEntity				
				.status(201)
				.headers(headers)
				.body("Data Saved Successfully");
		 
	}
	
	@GetMapping
	List<Payment> findAll(){
		return paymentService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		paymentService.delete(id);
		
		return ResponseEntity.status(200).headers(headers).body("Data deleted sucessesfully");
		
	}

}
