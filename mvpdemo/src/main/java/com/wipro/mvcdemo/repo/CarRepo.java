package com.wipro.mvcdemo.repo;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class CarRepo {
	

	public List<String> getCarList() {
		// TODO Auto-generated method stub
		List<String> carList= Arrays.asList("Audi","Mustang","Cherollet","Mazada");
		return carList;
	}
}
