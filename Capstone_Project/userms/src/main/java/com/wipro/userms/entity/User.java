package com.wipro.userms.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "email_id")
	String emailId;
	
	
	@Column(name = "password") // encrypted
	String passWord;
	
	@Column(name = "salt")
	String salt;
	
	@Column(name = "address")
	String address;
	
	@Column(name = "user_type") // 0- admin / 1- customer
	int userType;
	
	@Column(name = "is_loggedin") // make it false during logout
	boolean isLoggedIn; 

}
