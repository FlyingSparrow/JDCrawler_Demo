package com.sparrow;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
		String url = "http://movie.mtime.com/";
		String html = HttpUtils.getRawHtml(url);
		
		File file = new File("E:/mtimeMovie.txt");
		FileUtils.writeFile(file, html);
		
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("div[class=clearfix]");
		for (Element element : elements) {
//			System.out.println(element.html());
//			System.out.println("========================");
			String movieId = element.select("span").attr("objid");
			if(StringUtils.isNotEmpty(movieId)){
				String movieUrl = element.select("a").attr("href");
				String title = element.select("a").text();
				if(title.indexOf("(") != -1){
					title = title.substring(0, title.indexOf("("));
				}
				logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
				
				Movie movie = new Movie();
				movie.setMovieId("mtime"+movieId);
				movie.setTitle(title);
				movie.setUrl(movieUrl+"trailer.html");
			}
		}
	}
	
	@Test
	public void testBatchAddMovie(){
		List<Movie> list = new ArrayList<Movie>();
		
		String mtimeUrl = "http://movie.mtime.com/";
		String html = HttpUtils.getRawHtml(mtimeUrl);
		
		Document doc = Jsoup.parse(html);
		List<Movie> globalNewMovieList = getGlobalNewMovieList(doc);
		List<Movie> hotMovieList = getHotMovieList(doc);
		List<Movie> topHotMovieList = getTopHotMovieList(doc);
		list.addAll(globalNewMovieList);
		list.addAll(hotMovieList);
		list.addAll(topHotMovieList);
		
		String url = "/mtime/batchAddMovie";
		String response = performAndGetResponse(url, list);
		logger.info("批量添加电影信息，电影信息：{}，执行结果：{}", list, response);
	}
	
	private List<Movie> getGlobalNewMovieList(Document doc){
		List<Movie> list = new ArrayList<Movie>();
		
		logger.info("全球新片");
		Elements elements = doc.select("div[class=clearfix]");
		for (Element element : elements) {
			String movieId = element.select("span").attr("objid");
			if(StringUtils.isNotEmpty(movieId)){
				String movieUrl = element.select("a").attr("href");
				String title = element.select("a").text();
				if(title.indexOf("(") != -1){
					title = title.substring(0, title.indexOf("("));
				}
				logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
				
				Movie movie = new Movie();
				movie.setMovieId("mtime"+movieId);
				movie.setTitle(title);
				movie.setUrl(movieUrl+"trailer.html");
				movie.setIsCrawler(0);
				movie.setWebsite("时光网");
				list.add(movie);
			}
		}
		
		return list;
	}
	
	private List<Movie> getHotMovieList(Document doc){
		List<Movie> list = new ArrayList<Movie>();
		
		logger.info("热门电影");
		Elements elements = doc.select("div[id=topMovieRegion] > div > dl > dd");
		for (Element element : elements) {
			//首页的热门电影的电影信息
			String movieId = element.attr("movieid");
			if(StringUtils.isNotEmpty(movieId)){
				String movieUrl = element.select("h3 > a").attr("href");
				String title = element.select("h3 > a").text();
				if(title.indexOf("(") != -1){
					title = title.substring(0, title.indexOf("("));
				}
				logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
				
				Movie movie = new Movie();
				movie.setMovieId("mtime"+movieId);
				movie.setTitle(title);
				movie.setUrl(movieUrl+"trailer.html");
				movie.setIsCrawler(0);
				movie.setWebsite("时光网");
				list.add(movie);
			}
		}
		
		return list;
	}
	
	private List<Movie> getTopHotMovieList(Document doc){
		List<Movie> list = new ArrayList<Movie>();
		
		logger.info("热门榜单");
		Elements elements = doc.select("div[id=divToplistHot] > dl > dd > ul > li");
		for (Element element : elements) {
			String movieId = element.select("span").attr("objid");
			if(StringUtils.isNotEmpty(movieId)){
				String movieUrl = element.select("h3 > a").attr("href");
				String title = element.select("h3 > a").text();
				if(title.indexOf("(") != -1){
					title = title.substring(0, title.indexOf("("));
				}
				logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
				
				Movie movie = new Movie();
				movie.setMovieId("mtime"+movieId);
				movie.setTitle(title);
				movie.setUrl(movieUrl+"trailer.html");
				movie.setIsCrawler(0);
				movie.setWebsite("时光网");
				list.add(movie);
			}
		}
		
		return list;
	}
	
	@Test
	public void testFetchMtimeTrailerInfo(){
		String url = "http://video.mtime.com/trailer/";
		String html = HttpUtils.getRawHtml(url);
		
		File file = new File("E:/mtimeTrailer.txt");
		FileUtils.writeFile(file, html);
		
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("a[class=imgs_box]");
		for (Element element : elements) {
//			System.out.println(element.html());
//			System.out.println("========================");
			String previewUrl = element.attr("href");
			logger.info("previewUrl: {}", previewUrl);
		}
	}
	
}
