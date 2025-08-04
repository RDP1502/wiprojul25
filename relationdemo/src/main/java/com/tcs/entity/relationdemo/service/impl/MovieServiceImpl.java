package com.tcs.entity.relationdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.relationdemo.entity.Movie;
import com.tcs.entity.relationdemo.repo.MovieRepo;
import com.tcs.entity.relationdemo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepo movieRepo;
	
	@Override
	public void save(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.save(movie);
		

	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}

}
