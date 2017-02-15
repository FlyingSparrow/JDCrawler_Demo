package com.sparrow.crawler.service;

import com.sparrow.crawler.entity.Book;

public interface BookService {

	boolean save(Book book);
	
	Book findByBookId(String bookId);
	
}
