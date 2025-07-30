package com.wipro.aopdemo.service;

import org.springframework.stereotype.Component;

import com.wipro.aopdemo.exception.NoSeatAvailableException;

@Component
public class AirTravel {
	public void checkIn(boolean value) throws NoSeatAvailableException {
		if(value == true) {
			System.out.println("Check In Sucessfull");
		}
		else {
			throw new NoSeatAvailableException("No Seats available");
		}
		
	}
	public void collectBoardingPass() {
		System.out.println("Collected Boarding Pass");
	}
	public void doSecurityCheck() {
	System.out.println("Security Check Complete");
}
	public void doBoarding() {
	System.out.println("Done Boarding");
}
}
