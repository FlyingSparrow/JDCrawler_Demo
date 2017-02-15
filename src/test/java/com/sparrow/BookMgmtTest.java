package com.sparrow;

import java.util.Date;

import org.junit.Test;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.Book;
import com.sparrow.util.DateUtils;

/**
 * 
 * <p>Title: BookMgmtTest</p>
 * <p>Description: 图书管理的单元测试类</p>
 * @author wjc
 * @date 2017年2月14日
 */
public class BookMgmtTest extends BaseTests {

	/**
	 * 
	 * <p>Description: 测试添加图书</p>
	 * @author wjc
	 * @date 2017年2月14日
	 */
	@Test
	public void testAddBook(){
		Date currentDate = DateUtils.currentDate();
		
		Book book = new Book();
		book.setBookId("123456");
		book.setBookName("Java编程思想");
		book.setBookPrice(78D);
		book.setCreateDate(currentDate);
		book.setCreateUser("wjc");
		book.setUpdateDate(currentDate);
		book.setUpdateUser("wjc");
		
		String url = "/book/saveBook";
		String response = performAndGetResponse(url, book);
		logger.info("添加图书，图书信息：{}，执行结果：{}", book, response);
	}
	
}
