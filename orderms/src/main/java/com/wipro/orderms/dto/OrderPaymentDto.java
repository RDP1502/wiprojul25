package com.wipro.orderms.dto;



import lombok.Data;

@Data
public class OrderPaymentDto {
		
	public OrderDto orderDto;
	public Payment payment;	
	
}
