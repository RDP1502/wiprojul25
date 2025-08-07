package com.wipro.notificationms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.notificationms.dto.UserDto;


@RestController
@RequestMapping("/notify")
public class NotificationController {
	
	@PostMapping
	public void notify(@RequestBody UserDto userDto) {
		System.out.println("Notification : "+ userDto.getUserName() + userDto.getStatus());
	}
}
