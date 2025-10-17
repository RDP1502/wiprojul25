package com.wipro.orderms.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.orderms.entity.OrderItem;
import com.wipro.orderms.entity.Orders;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.util.AppConstant;



@Service
public class PTOConsumer {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	@KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "update_status")
	public void receiveOrderDetails(Orders orders) {
	    try {
	        System.out.println("---Message Received ---" + orders);
	        
	        // Safe iteration using Optional
	        java.util.Optional.ofNullable(orders.getItems())
	                .orElse(java.util.Collections.emptyList())
	                .forEach(item -> {
	                    System.out.println("Processing order item: " + item);
	                    // Add your item processing logic here
	                });
	        
	        orders.setOrderDate(LocalDateTime.now());
	        orders.setOrderStatus("successful");
	        
	        orderRepo.save(orders);
	        System.out.println("Order saved successfully: " + orders.getId());
	        
	    } catch (Exception e) {
	        System.err.println("Error processing order: " + orders);
	        e.printStackTrace();
	        throw new RuntimeException("Failed to process order", e);
	    }
	}
}