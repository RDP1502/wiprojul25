//package com.wipro.restdemo.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WeatherController {
//	
//	@GetMapping("/weather")
//	String getWeather(@RequestParam String city, @RequestParam String day) {
//		return "Weather in "+ city+ " for "+ day+ " is cloudy";
//	}
//	@GetMapping("/tocentigrade/{num}")
//	double convertTOCentigrade(@PathVariable double num) {
//		return (num-32)*5/9;
//	}
//	
//
//}
