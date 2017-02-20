package com.sparrow.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.crawler.entity.mtime.MovieComment;

/**
 * 
 * <p>Title: MovieCommentRepository</p>
 * <p>Description: 电影评论信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年2月18日
 */
public interface MovieCommentRepository extends JpaSpecificationExecutor<MovieComment>, 
	JpaRepository<MovieComment, Long>, PagingAndSortingRepository<MovieComment, Long> {
}
