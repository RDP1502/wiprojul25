package com.wipro.userms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermsApplication.class, args);
	}

}
