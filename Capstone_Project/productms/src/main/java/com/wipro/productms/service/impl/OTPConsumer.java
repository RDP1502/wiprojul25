package com.wipro.productms.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.productms.dto.OrderItem;
import com.wipro.productms.dto.Orders;
import com.wipro.productms.entity.Product;
import com.wipro.productms.repo.ProductRepo;
import com.wipro.productms.util.AppConstant;


@Service
public class OTPConsumer {
	
//	@Autowired
//	ProductRepo productRepo;
//	
//	@Autowired
//	KafkaTemplate kafkaTemplate;
//	
//	@KafkaListener(topics= AppConstant.INCOMING_TOPIC_NAME,groupId="reduce_stock")
//	public void receiveOrderDetails(Orders orders) {
//		System.out.println("---Message Received to product ---"+orders);
//		System.out.println("in itmes"+ orders.getItems());
//		List<Product> products;
//		List<OrderItem> items = orders.getItems();
//		for (OrderItem item : items) {
//		    productRepo.findById(item.getProductId()).ifPresent(product -> {
//		        int newQty = product.getAvailableQty() - item.getQuantity();
//
//		        if (newQty < 0) {
//		            throw new IllegalStateException("Not enough stock for product " + product.getId());
//		        }
//
//		        product.setAvailableQty(newQty);
//		        productRepo.save(product);
//		    });
//		    
//		}
//		orders.setOrderStatus("Successful");
//	    kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, orders);
// }

	}
