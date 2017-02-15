package com.sparrow.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.crawler.entity.Book;

/**
 * 
 * <p>Title: BookRepository</p>
 * <p>Description: 图书信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年2月14日
 */
public interface BookRepository extends JpaSpecificationExecutor<Book>, 
	JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {

	Book findByBookId(String bookId);
}
