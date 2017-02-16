package com.sparrow.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.Book;
import com.sparrow.crawler.repository.BookRepository;
import com.sparrow.crawler.service.BookService;

/**
 * 
 * <p>Title: BookServiceImpl</p>
 * <p>Description: 图书信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月14日
 */
@Transactional
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public boolean save(Book book) {
		bookRepository.save(book);
		return true;
	}

	@Override
	public Book findByBookId(String bookId) {
		return bookRepository.findByBookId(bookId);
	}

	@Override
	public boolean batchAddBook(List<Book> list) {
		bookRepository.save(list);
		return true;
	}

}
