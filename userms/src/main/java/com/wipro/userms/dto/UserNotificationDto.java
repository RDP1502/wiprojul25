package com.wipro.userms.dto;

import com.wipro.userms.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  
@NoArgsConstructor
public class UserNotificationDto {
	
	User user;
	String action;

}
