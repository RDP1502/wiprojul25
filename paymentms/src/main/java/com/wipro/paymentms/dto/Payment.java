package com.wipro.paymentms.dto;

import lombok.Data;

@Data
public class Payment {
	
	int id;
	int orderId;
	boolean paymentStatus;
	double paymentAmount;

}
