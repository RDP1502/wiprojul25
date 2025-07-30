package com.wipro.springdemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.springdemo.beans.Mobile;


public class Appv2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(Appv2.class);
		ctx.scan("com.wipro.springdemo.*");
		Mobile mobile = ctx.getBean(Mobile.class);
		System.out.println(mobile.getDisplay());
	}
}
