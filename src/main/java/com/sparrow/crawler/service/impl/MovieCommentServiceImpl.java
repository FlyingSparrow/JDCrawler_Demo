package com.sparrow.crawler.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.mtime.MovieComment;
import com.sparrow.crawler.repository.MovieCommentRepository;
import com.sparrow.crawler.service.MovieCommentService;

/**
 * 
 * <p>Title: MovieCommentServiceImpl</p>
 * <p>Description: 电影评论信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月18日
 */
@Transactional
@Service
public class MovieCommentServiceImpl implements MovieCommentService {

	@Autowired
	private MovieCommentRepository movieCommentRepository;
	
	@Override
	public boolean save(MovieComment mc) {
		movieCommentRepository.save(mc);
		return true;
	}

}
