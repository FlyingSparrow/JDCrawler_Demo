package com.sparrow.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.crawler.entity.mtime.MovieUrl;
import com.sparrow.crawler.repository.MovieUrlRepository;
import com.sparrow.crawler.service.MovieService;
import com.sparrow.crawler.service.MovieUrlService;

/**
 * 
 * <p>Title: MovieUrlServiceImpl</p>
 * <p>Description: 电影url信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月18日
 */
@Transactional
@Service
public class MovieUrlServiceImpl implements MovieUrlService {

	@Autowired
	private MovieUrlRepository movieUrlRepository;
	@Autowired
	private MovieService movieService;
	
	@Override
	public boolean save(MovieUrl movieUrl) {
		movieUrlRepository.save(movieUrl);
		return true;
	}

	@Override
	public boolean isExist(String prmovieId) {
		MovieUrl model = movieUrlRepository.findByPrmovieId(prmovieId);
		
		return (model != null);
	}

	@Override
	public boolean batchAddMovieUrl(List<MovieUrl> list, String movieId) {
		movieUrlRepository.save(list);
		Movie movie = movieService.findByMovieId(movieId);
		if(movie != null){
			movie.setIsCrawler(1);
			movieService.save(movie);
		}
		
		return true;
	}

	@Override
	public List<MovieUrl> findListByIsCrawler(Integer isCrawler) {
		return movieUrlRepository.findListByIsCrawler(isCrawler);
	}
	
}
