package com.wipro.orderms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.dto.Payment;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.OrderService;
import com.wipro.orderms.service.PaymentConnectService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PaymentConnectService paymentConnectService;
	
	@Override
	@CircuitBreaker(name="order-cb" , fallbackMethod="handleFallBack")
	public void save(Order order) {
		// TODO Auto-generated method stub
		order.setOrderStatus("I");
		orderRepo.save(order);
		String url = "http://paymentms/payment";
		Payment payment = new Payment();
		payment.setOrderId(order.getId());
		payment.setPaymentAmount(order.getOrderValue());
		payment.setPaymentStatus(true);
		
		//try {
			
			ResponseEntity<Payment> response = restTemplate.postForEntity(url, payment, Payment.class);
			if(response.getStatusCode() == HttpStatusCode.valueOf(200)) {
				order.setOrderStatus("P");
			}
		//}catch(Exception e){
//			System.out.println(e);
//			order.setOrderStatus("C");
//			
//		}
		orderRepo.save(order);
		
	}
	
	void handleFallBack(Order order,Throwable t)
	{
		
		System.out.println("--System is down--");
		//return "System is down";
	}

	
	
	
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
		
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		Order order = orderRepo.findById(id).orElse(null);
		if(order !=null) {
			ResponseEntity<Payment> paymentResponse = paymentConnectService.findById(id);
			if(paymentResponse.getStatusCode()==HttpStatus.OK)
            {
                            
                Payment allPayments = paymentResponse.getBody();

                Payment matchedPayment = null;
                if (allPayments != null) {
                    matchedPayment.setId(allPayments.getId());
                    matchedPayment.setOrderId(allPayments.getOrderId());
                    matchedPayment.setPaymentAmount(allPayments.getPaymentAmount());  
                }

                order.setPayment(matchedPayment);
            }
//        
		}
		return order;
	}
//	.stream()
//    .filter(payment -> payment.getOrderId() == order.getId())
//    .findFirst()
//    .orElse(null);
}
