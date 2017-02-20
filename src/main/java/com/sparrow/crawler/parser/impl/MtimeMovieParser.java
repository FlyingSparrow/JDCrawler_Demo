package com.sparrow.crawler.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sparrow.crawler.entity.mtime.JsonModel;
import com.sparrow.crawler.entity.mtime.MtimeModel;
import com.sparrow.crawler.parser.Parser;

/**
 * 
 * <p>Title: MtimeMovieParser</p>
 * <p>Description: 时光网电影信息解析器，解析html</p>
 * @author wjc
 * @date 2017年2月20日
 */
@Component
public class MtimeMovieParser implements Parser<MtimeModel> {

	/**
	 * 
	 * <p>Description: 解析时光网的电影信息</p>
	 * @param html
	 * @return
	 * @author wjc
	 * @date 2017年2月15日
	 */
	public List<MtimeModel> parse(String html) {
		List<MtimeModel> result = new ArrayList<MtimeModel>();
		
		String data = getPriviewData(html);
		if (data.length() != 0) {
			List<JsonModel> jmList = JSON.parseArray(data, JsonModel.class);
			for (JsonModel item : jmList) {
				String VideoID = "mtime" + item.getVideoId();
				String MovieID = "mtime" + item.getMovieId();
				String ShortTitle = item.getShortTitle();
				String url = "http://video.mtime.com/" + item.getVideoId() + "/?mid" + item.getMovieId();
				
				MtimeModel model = new MtimeModel();
				model.setPrmovieId(VideoID);
				model.setUrl(url);
				model.setMovieId(MovieID);
				model.setTitle(ShortTitle);
				result.add(model);
			}
		}

		return result;
	}
	
	/**
	 * 
	 * <p>Description: 获取预告片数据</p>
	 * @param html
	 * @return
	 * @author wjc
	 * @date 2017年2月20日
	 */
	private String getPriviewData(String html){
		Pattern previewRegex = Pattern.compile("预告片\":(.*?)\\,(\"拍摄花絮|\"精彩片段)");
		Matcher matcher = previewRegex.matcher(html);
		
		String data = "";
		while (matcher.find()) {
			// 待解析的json字符串
			data = matcher.group(1);
		}
		
		return data;
	}
	
}
