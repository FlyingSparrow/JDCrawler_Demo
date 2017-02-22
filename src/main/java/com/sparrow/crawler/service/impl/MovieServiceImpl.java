package com.sparrow.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.crawler.repository.MovieRepository;
import com.sparrow.crawler.service.MovieService;

/**
 * 
 * <p>Title: MovieServiceImpl</p>
 * <p>Description: 电影信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月18日
 */
@Transactional
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public boolean save(Movie movie) {
		movieRepository.save(movie);
		return true;
	}

	@Override
	public boolean isExist(String movieId) {
		Movie movie = movieRepository.findByMovieId(movieId);
		
		return (movie != null);
	}

	@Override
	public boolean batchAddMovie(List<Movie> list) {
		movieRepository.save(list);
		return true;
	}

}
