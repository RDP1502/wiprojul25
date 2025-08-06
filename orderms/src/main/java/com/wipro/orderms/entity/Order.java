package com.wipro.orderms.entity;

import com.wipro.orderms.dto.Payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "order_name")
	String orderNumber;
	
	@Column(name = "order_value")
	double orderValue;
	
	@Column(name = "order_status")
	String orderStatus;
	
	@Transient
	Payment payment;

}
