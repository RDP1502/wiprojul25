package com.wipro.userms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wipro.userms.dto.UserNotificationDto;
@Component
public class NotificationClient {
	
	

	    @Autowired
	    private RestTemplate restTemplate;


	    private static final String NOTIFICATIONMS_URL = "http://notificationsms/notify";


	    public void notify(UserNotificationDto dto) {
	   
	        restTemplate.postForObject(NOTIFICATIONMS_URL, dto, String.class);
	    }
	}
