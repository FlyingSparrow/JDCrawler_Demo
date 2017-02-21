package com.sparrow.crawler.mtime.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.sparrow.crawler.entity.mtime.JsonModel;
import com.sparrow.crawler.entity.mtime.MtimeModel;

public class MtimeParse {
	
	public static List<MtimeModel> getData(Document doc) {
		List<MtimeModel> mtimeData = new ArrayList<MtimeModel>();
		// 获取待解析的html文件
		String html = doc.html();
		// System.out.println(html);
		// 通过正则表达获取，所要解析的json数据，只要预告片不要花絮
		Pattern data = Pattern.compile("预告片\":(.*?)\\,\"拍摄花絮");
		Matcher dataMatcher = data.matcher(html);
		String da = "";
		while (dataMatcher.find()) {
			// 待解析的json字符串
			da = dataMatcher.group(1);
		}
		// jsoup获取movieId（影片id）
		String movieId = "mtime"
				+ doc.select("h1[property=v:itemreviewed]").select("a").attr("href").replaceAll("\\D", "").trim();
		// 正则匹配获取videoID（预告片id）
		Pattern videoID = Pattern.compile("VideoID\"(.*?)\"");
		// 正则匹配获取shortTitle（预告片名称）
		Pattern titlePattern = Pattern.compile("ShortTitle\":\"(.*?)\"");
		Matcher videoIDMatcher = videoID.matcher(da);
		Matcher titleMatcher = titlePattern.matcher(da);
		ArrayList<String> urldatas = new ArrayList<String>();
		while (videoIDMatcher.find()) {
			urldatas.add(videoIDMatcher.group(1));
		}
		ArrayList<String> titles = new ArrayList<String>();
		while (titleMatcher.find()) {
			titles.add(titleMatcher.group(1));
		}
		for (int i = 0; i < titles.size(); i++) {
			MtimeModel mtimeModel = new MtimeModel();
			String prmovieId = "mtime" + urldatas.get(i).replaceAll("\\D", "").trim();
			String url = "http://video.mtime.com/" + urldatas.get(i).replaceAll("\\D", "").trim() + "/?mid="
					+ doc.select("h1[property=v:itemreviewed]").select("a").attr("href").replaceAll("\\D", "").trim();
			String title = titles.get(i);
			mtimeModel.setPrmovieId(prmovieId);
			mtimeModel.setUrl(url);
			mtimeModel.setMovieId(movieId);
			mtimeModel.setTitle(title);
			mtimeData.add(mtimeModel);
		}
		// fastJson测试
		// just contain the preview
		List<JsonModel> mtimeJsonData = new ArrayList<JsonModel>();
		Pattern data1 = Pattern.compile("预告片\":(.*?)\\,(\"拍摄花絮|\"精彩片段)");
		Matcher dataMatcher1 = data1.matcher(html);
		String da1 = "";
		while (dataMatcher1.find()) {
			// 待解析的json字符串
			da1 = dataMatcher1.group(1);
		}
		if (da1.length() != 0) {
			List<JsonModel> jsonmodel1 = JSON.parseArray(da1, JsonModel.class);
			for (JsonModel jso : jsonmodel1) {
				JsonModel mtimeModel = new JsonModel();
				String VideoID = "mtime" + jso.getVideoId();
				String MovieID = "mtime" + jso.getMovieId();
				String ShortTitle = jso.getShortTitle();
				String url = "http://video.mtime.com/" + jso.getVideoId() + "/?mid" + jso.getMovieId();
				mtimeModel.setPrmovieId(VideoID);
				mtimeModel.setUrl(url);
				mtimeModel.setMovieId(MovieID);
				mtimeModel.setShortTitle(ShortTitle);
				mtimeJsonData.add(mtimeModel);
			}
		}

		return mtimeData;
	}
}
