package com.wipro.orderms.dto;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class OrderDto {
	
	int id;
	String orderNumber;
	double orderValue;
	String orderStatus;
	
	@Transient
	Payment payment;
}
