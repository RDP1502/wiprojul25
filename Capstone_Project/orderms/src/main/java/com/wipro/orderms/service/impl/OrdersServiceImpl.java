package com.wipro.orderms.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.entity.OrderItem;
import com.wipro.orderms.entity.Orders;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.OrderService;

@Service
public class OrdersServiceImpl implements OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	
	@Autowired
	RestTemplate  restTemplate;
	
	@Autowired
	KafkaTemplate kafkaTemplate;

	@Override
	public ResponseEntity save(Orders orders) {
		// TODO Auto-generated method stub
		orders.setOrderDate(LocalDateTime.now());
		if(orders.getItems() != null) {
	        for(OrderItem item : orders.getItems()) {
	            item.setOrder(orders);  // ← CRUCIAL: Link each item to the order
	        }
	    }
		
//		orders.setOrderId(Math.abs(UUID.randomUUID().hashCode()));
		orders.setOrderStatus("Pending");
		orderRepo.save(orders);
		return new ResponseEntity<>("Order saved successfully", HttpStatus.OK);
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Orders findById(int id) {
		// TODO Auto-generated method stub
		Optional<Orders> savedOrder = orderRepo.findById(id);
		if(savedOrder.isPresent()) {
			return savedOrder.get();
		}else {
			return null;
		}	
	}

	@Override
	public ResponseEntity update(int orderId, Orders orders) {
		// TODO Auto-generated method stub
		Orders savedOrder = orderRepo.findById(orderId).get();
		if(savedOrder.getId()==orderId && savedOrder.getOrderStatus() != "Successfull"
				&& savedOrder.getOrderStatus() != "Cancelled") {
			savedOrder.setItems(orders.getItems());
			savedOrder.setOrderDate(orders.getOrderDate());
			savedOrder.setUserId(orders.getUserId());
			savedOrder.setTotalAmount(orders.getTotalAmount());
			orderRepo.save(savedOrder);
			return new ResponseEntity("Order updated successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Order not found", HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity delete(int id) {
		// TODO Auto-generated method stub
		Optional<Orders> extOrder = orderRepo.findById(id);
		if(extOrder.isPresent()) {
			orderRepo.deleteById(id);
			return new ResponseEntity<>("Order deleted successfully" , HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Order not found" , HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public List<Orders> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Orders> allOrders = orderRepo.findAll();
		List<Orders> userOrders=new ArrayList<>();
		for(Orders orders:allOrders) {
			if(orders.getUserId()== userId) {
				userOrders.add(orders);
			}
		}
		
		return userOrders;
	}

}
