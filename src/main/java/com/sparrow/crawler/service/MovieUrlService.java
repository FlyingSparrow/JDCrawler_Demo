package com.sparrow.crawler.service;

import java.util.List;

import com.sparrow.crawler.entity.mtime.MovieUrl;

public interface MovieUrlService {

	boolean save(MovieUrl book);
	
	boolean isExist(String prmovieId);
	
	boolean batchAddMovieUrl(List<MovieUrl> list, String movieId);
	
	List<MovieUrl> findListByIsCrawler(Integer isCrawler);
	
}
