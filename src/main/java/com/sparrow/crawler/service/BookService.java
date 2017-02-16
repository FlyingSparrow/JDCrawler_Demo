package com.sparrow.crawler.service;

import java.util.List;

import com.sparrow.crawler.entity.Book;

public interface BookService {

	boolean save(Book book);
	
	Book findByBookId(String bookId);
	
	boolean batchAddBook(List<Book> list);
	
}
