package com.wipro.springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Mobile {
	Display display;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}
	@Autowired
	public Mobile(Display display) {
		super();
		this.display = display;
	}
	
}
