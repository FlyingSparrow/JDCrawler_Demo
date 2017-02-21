package com.sparrow;

import java.io.File;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.Book;
import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.util.DateUtils;
import com.sparrow.util.FileUtils;
import com.sparrow.util.HttpUtils;

/**
 * 
 * <p>Title: MtimeMovieTest</p>
 * <p>Description: 时光网电影信息管理的单元测试类</p>
 * @author wjc
 * @date 2017年2月18日
 */
public class MtimeMovieTest extends BaseTests {

	@Test
	public void testBatchAddMovieUrl(){
		Date currentDate = DateUtils.currentDate();
		
		Book book = new Book();
		book.setBookId("000002");
		book.setBookName("Effective Java");
		book.setBookPrice(78D);
		book.setCreateDate(currentDate);
		book.setCreateUser("wjc");
		book.setUpdateDate(currentDate);
		book.setUpdateUser("wjc");
		
		String url = "/mtime/batchAddMovieUrl";
		String response = performAndGetResponse(url, book);
		logger.info("添加图书，图书信息：{}，执行结果：{}", book, response);
	}
	
	@Test
	public void testFetchMtimeMovieInfo(){
		String url = "http://theater.mtime.com/China_Beijing/";
		String html = HttpUtils.getRawHtml(url);
		
		File file = new File("E:/mtimeMovie.txt");
		FileUtils.writeFile(file, html);
		
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("div[id=hotplayContent]").select("div[class=othermovie] > ul > li");
		for (Element element : elements) {
//			System.out.println(element.html());
//			System.out.println("========================");
			String movieId = element.select("*[class=score none]").attr("mid");
			String title = element.select("dl > dt > a").text();
			String movieUrl = element.select("dl > dt > a").attr("href");
			logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
			
			Movie movie = new Movie();
			movie.setMovieId(movieId);
			movie.setTitle(title);
			movie.setUrl(movieUrl);
		}
	}
	
}
