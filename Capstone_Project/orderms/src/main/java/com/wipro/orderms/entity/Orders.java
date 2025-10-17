package com.wipro.orderms.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	

	
	@Column(name = "user_id")
	private int userId;
	
	//private Map<Integer,Integer> productQuantityMap; /// ask sir about this
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "order_date")
	private LocalDateTime orderDate;
 
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<OrderItem> items;
}
