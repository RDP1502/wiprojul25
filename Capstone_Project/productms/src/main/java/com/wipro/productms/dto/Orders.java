package com.wipro.productms.dto;

import java.time.LocalDateTime;
import java.util.List;



import lombok.Data;


@Data
public class Orders {
	
	int id;
	
	 int orderId;
	
	int userId;
	
	//private Map<Integer,Integer> productQuantityMap; /// ask sir about this
	
	
	 double totalAmount;
	
	
	 String orderStatus;
	
	
	 LocalDateTime orderDate;
 
     List<OrderItem> items;
}
