package com.wipro.aopdemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.aopdemo.exception.NoSeatAvailableException;
import com.wipro.aopdemo.service.AirTravel;
public class App {
  public static void main(String[] args) throws NoSeatAvailableException {
	  
	  AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
	  ctx.scan("com.wipro.aopdemo.*");
	  ctx.refresh();
	  
	  AirTravel airTravel = ctx.getBean(AirTravel.class);
	  
	  try {
		  airTravel.checkIn(true);
		  airTravel.collectBoardingPass();
		  airTravel.doSecurityCheck();
		  airTravel.doBoarding();
		  }catch(NoSeatAvailableException e) {
			  System.out.println(e.getMessage());
		  }
	  
	  
	  //System.out.println("Now check in false");
	  
    
  }
}
