package com.tcs.entity.relationdemo.service;

import java.util.List;

import com.tcs.entity.relationdemo.entity.Movie;

public interface MovieService {
	void save(Movie movie);
	List<Movie> findAll();
}
