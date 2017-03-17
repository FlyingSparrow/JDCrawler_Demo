package com.sparrow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.mtime.JsonModel;
import com.sparrow.crawler.entity.mtime.Movie;
import com.sparrow.crawler.entity.mtime.MovieUrl;
import com.sparrow.crawler.service.MovieService;
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
	
	@Autowired
	private MovieService movieService;
	
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
		File file = new File("E:/mtimeMovie_20170314.txt");
		FileUtils.writeFile(file, html);
		
		Document doc = Jsoup.parse(html);
		List<Movie> globalNewMovieList = getGlobalNewMovieList(doc);
		List<Movie> hotMovieList = getHotMovieList(doc);
		List<Movie> topHotMovieList = getTopHotMovieList(doc);
		list.addAll(globalNewMovieList);
		list.addAll(hotMovieList);
		list.addAll(topHotMovieList);
		
		List<Movie> distinctMovieList = getDistinctMovieList(list);
		
		String url = "/mtime/batchAddMovie";
		String response = performAndGetResponse(url, distinctMovieList);
		logger.info("批量添加电影信息，电影信息：{}，执行结果：{}", distinctMovieList, response);
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
				if(movieId.length() > 5){
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
				}else{
					logger.info("length <= 5, movieId: {}", movieId);
				}
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
				if(movieId.length() > 5){
					String movieUrl = element.select("h3 > a").attr("href");
					if(!movieUrl.startsWith("http://people")){
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
				}else{
					logger.info("length <= 5, movieId: {}", movieId);
				}
			}
		}
		
		return list;
	}
	
	@Test
	public void testFetchMtimeTrailerInfo(){
		getMovieUrlList();
	}
	
	@Test
	public void testFindAllMovie(){
		String url = "/mtime/findAllMovie";
		String response = performAndGetResponse(url, null);
		logger.info("执行结果：{}", response);
	}
	
	@Test
	public void testBatchAddMovieUrl(){
		String url = "/mtime/batchAddMovieUrl";
		List<Movie> list = movieService.findAll();
		if(list != null){
			for(Movie item : list){
				Map<String, Object> params = new HashMap<String, Object>();
				List<MovieUrl> muList = getMovieUrlListByMovieId(item.getMovieId());
				params.put("list", JSON.toJSONString(muList));
				params.put("movieId", item.getMovieId());
				String response = performAndGetResponse(url, muList);
				logger.info("执行结果：{}", response);
			}
		}
	}
	
	private List<MovieUrl> getMovieUrlListByMovieId(String movieId){
		List<MovieUrl> result = new ArrayList<MovieUrl>();
		List<MovieUrl> muList = getMovieUrlList();
		if(muList != null){
			for(MovieUrl item : muList){
				if(item.getMovieId().equals(movieId)){
					result.add(item);
				}
			}
		}
		
		return result;
	}
	
	private List<MovieUrl> getMovieUrlList(){
		List<MovieUrl> muList = new ArrayList<MovieUrl>();
		
		List<Movie> list = movieService.findAll();
		if(list != null){
			Pattern data1 = Pattern.compile("预告片\":(.*?)\\,(\"拍摄花絮|\"精彩片段)");
			for(Movie item : list){
				String url = item.getUrl();
				String html = HttpUtils.getRawHtml(url);
				
				Matcher dataMatcher1 = data1.matcher(html);
				String da1 = "";
				// 待解析的json字符串
				while (dataMatcher1.find()) {
					//String group = dataMatcher1.group();
					da1 = dataMatcher1.group(1);
					//logger.info("group: {}, group1: {}", group, da1);
				}
				if (da1.length() != 0) {
					List<JsonModel> jsonList = JSON.parseArray(da1, JsonModel.class);
					for(JsonModel jmItem : jsonList){
						String mtimeMovieId = "mtime"+jmItem.getMovieId();
						MovieUrl mu = new MovieUrl();
						mu.setPrmovieId("mtime"+jmItem.getVideoId());
						mu.setMovieId(mtimeMovieId);
						mu.setUrl(jmItem.getUrl());
						mu.setTitle(jmItem.getShortTitle());
						muList.add(mu);
					}
				}
			}
			logger.info("muList: {}", muList);
		}
		
		return muList;
	}
	
	@Test
	public void testFindByIsCrawler(){
		String url = "/mtime/findMovieUrlList";
		Integer isCrawler = 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isCrawler", isCrawler);
		String response = performAndGetResponse(url, params);
		logger.info("执行结果：{}", response);
	}
	
}
