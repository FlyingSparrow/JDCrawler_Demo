package com.sparrow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.mtime.Movie;
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
		
		List<Movie> distinctMovieList = getDistinctMovieList(list);
		
//		String url = "/mtime/batchAddMovie";
//		String response = performAndGetResponse(url, distinctMovieList);
//		logger.info("批量添加电影信息，电影信息：{}，执行结果：{}", distinctMovieList, response);
	}
	
	private List<Movie> getDistinctMovieList(List<Movie> list){
		List<Movie> result = new ArrayList<Movie>();
		Map<String, Movie> map = new TreeMap<String, Movie>();
		for(Movie item : list){
			map.put(item.getMovieId(), item);
		}
		result.addAll(map.values());
		
		return result;
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
			System.out.println(element.outerHtml());
			String movieId = element.select("span").attr("objid");
			if(StringUtils.isNotEmpty(movieId)){
				String movieUrl = element.select("h3 > a").attr("href");
				if(!movieUrl.startsWith("http://people")){
					String title = element.select("h3 > a").text();
					if(title.indexOf("(") != -1){
						title = title.substring(0, title.indexOf("("));
					}
					//logger.info("movieId: {}， title: {}, movieUrl: {}", movieId, title, movieUrl);
					
					Movie movie = new Movie();
					movie.setMovieId("mtime"+movieId);
					movie.setTitle(title);
					movie.setUrl(movieUrl+"trailer.html");
					movie.setIsCrawler(0);
					movie.setWebsite("时光网");
					list.add(movie);
				}
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
