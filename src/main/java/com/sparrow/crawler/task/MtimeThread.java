package com.sparrow.crawler.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.sparrow.crawler.entity.mtime.JsonModel;
import com.sparrow.crawler.entity.mtime.MovieUrl;
import com.sparrow.crawler.service.MovieUrlService;
import com.sparrow.util.HttpUtils;

public class MtimeThread extends Thread {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private MovieUrlService movieUrlService;
	
	private String url;
	private String movieId;
	
	public MtimeThread(String url, String movieId, MovieUrlService movieUrlService){
		this.url = url;
		this.movieId = movieId;
		this.movieUrlService = movieUrlService;
	}
	
	@Override
	public void run() {
		logger.info("url: {}", url);
		String html = HttpUtils.getRawHtml(url);
		//预告片的正则表达式
		Pattern previewRegex = Pattern.compile("预告片\":(.*?)\\,(\"拍摄花絮|\"精彩片段)");
		Matcher matcher = previewRegex.matcher(html);
		String info = "";
		while (matcher.find()) {
			// 待解析的json字符串
			info = matcher.group(1);
		}
		List<MovieUrl> muList = new ArrayList<MovieUrl>();
		if (info.length() != 0) {
//			logger.info("info: {}", info);
			List<JsonModel> jsonList = JSON.parseArray(info, JsonModel.class);
			for(JsonModel jmItem : jsonList){
				MovieUrl mu = new MovieUrl();
				mu.setPrmovieId("mtime"+jmItem.getVideoId());
//				mu.setMovieId("mtime"+jmItem.getMovieId());
				mu.setMovieId(movieId);
				mu.setUrl(jmItem.getUrl());
				mu.setTitle(jmItem.getShortTitle());
				muList.add(mu);
			}
		}
		logger.info("muList's size: {}", muList.size());
		movieUrlService.batchAddMovieUrl(muList, movieId);
	}
	
}
