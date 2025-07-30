package com.wipro.aopdemo.exception;


public class NoSeatAvailableException extends Exception {
	String message;
	public NoSeatAvailableException(String message) {
		super(message);
	}
		
	
}
