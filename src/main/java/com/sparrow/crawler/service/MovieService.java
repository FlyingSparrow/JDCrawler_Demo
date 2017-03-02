package com.sparrow.crawler.service;

import java.util.List;

import com.sparrow.crawler.entity.mtime.Movie;

public interface MovieService {

	boolean save(Movie book);
	
	boolean isExist(String movieId);
	
	boolean batchAddMovie(List<Movie> list);
	
	List<Movie> findAll();
	
	Movie findByMovieId(String movieId);
	
}
