package com.wipro.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AirTravelAspect {
	
	
	@Before("execution(* com.wipro.aopdemo.service.AirTravel.checkIn(*))")
	void showPhotoId(JoinPoint jp) {
		System.out.println("Show your photo id");
	}
	@Before("execution(* com.wipro.aopdemo.service.AirTravel.do*())")
	void showBoardingPass(JoinPoint jp) {
		System.out.println("Show your Boarding Pass");
		
	}
//	@Before("execution(* com.wipro.aopdemo.service.AirTravel.doBoarding())")
//	void showBoardingPass1(JoinPoint jp) {
//		System.out.println("Show your Boarding Pass");
//		
//	}

	@AfterThrowing(pointcut="execution(* com.wipro.aopdemo.service.AirTravel.checkIn(*))", throwing="ex")
	void informRestaurnatManager(JoinPoint jp,Throwable ex)
	{
		System.out.println("Connect to air travel manager");
	}

}
