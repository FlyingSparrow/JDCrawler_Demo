package com.sparrow.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.crawler.entity.mtime.Movie;

/**
 * 
 * <p>Title: MovieRepository</p>
 * <p>Description: 电影信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年2月18日
 */
public interface MovieRepository extends JpaSpecificationExecutor<Movie>, 
	JpaRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {
}
