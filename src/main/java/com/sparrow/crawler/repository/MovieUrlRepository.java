package com.sparrow.crawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.crawler.entity.mtime.MovieUrl;

/**
 * 
 * <p>Title: MovieUrlRepository</p>
 * <p>Description: 电影url信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年2月18日
 */
public interface MovieUrlRepository extends JpaSpecificationExecutor<MovieUrl>, 
	JpaRepository<MovieUrl, Long>, PagingAndSortingRepository<MovieUrl, Long> {
	
	MovieUrl findByPrmovieId(String prmovieId);
	
	List<MovieUrl> findListByIsCrawler(Integer isCrawler);
}
