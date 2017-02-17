package com.sparrow;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.Book;
import com.sparrow.crawler.parser.impl.JdParser;
import com.sparrow.util.DateUtils;
import com.sparrow.util.HttpUtils;

/**
 * 
 * <p>Title: BookMgmtTest</p>
 * <p>Description: 图书管理的单元测试类</p>
 * @author wjc
 * @date 2017年2月14日
 */
public class BookMgmtTest extends BaseTests {

	@Autowired
	private JdParser jdParser;
	
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
		book.setBookId("000002");
		book.setBookName("Effective Java");
		book.setBookPrice(78D);
		book.setCreateDate(currentDate);
		book.setCreateUser("wjc");
		book.setUpdateDate(currentDate);
		book.setUpdateUser("wjc");
		
		String url = "/book/saveBook";
		String response = performAndGetResponse(url, book);
		logger.info("添加图书，图书信息：{}，执行结果：{}", book, response);
	}
	
	@Test
	public void testJdCrawler(){
		// 我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
		String url = "http://search.jd.com/Search?keyword=Linux&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
		String html = HttpUtils.getRawHtml(url);
		// 抓取的数据
		List<Book> list = jdParser.parse(html);
		// 循环输出抓取的数据
		for (Book book : list) {
			logger.info("bookId: {}, bookName: {}, bookPrice: {}", book.getBookId(), 
					book.getBookName(), book.getBookPrice());
		}
	}
	
	/**
	 * 
	 * <p>Description: 测试批量添加图书</p>
	 * @author wjc
	 * @date 2017年2月15日
	 */
	@Test
	public void testBatchAddBook(){
		// 我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
		String httpUrl = "http://search.jd.com/Search?keyword=Linux&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
		String html = HttpUtils.getRawHtml(httpUrl);
		// 抓取的数据
		List<Book> list = jdParser.parse(html);
		
		String url = "/book/batchAddBook";
		String response = performAndGetResponse(url, list);
		logger.info("批量添加图书，图书信息：{}，执行结果：{}", list, response);
	}
	
}
