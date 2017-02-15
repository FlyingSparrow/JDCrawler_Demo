package com.sparrow.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/**
 * 
 * <p>
 * Title: HttpUtils
 * </p>
 * <p>
 * Description: 处理http请求的工具类
 * </p>
 * 
 * @author wjc
 * @date 2017年2月15日
 */
public class HttpUtils {

	private HttpUtils() {
	}

	public static HttpResponse getRawHtml(HttpClient client, String url) {
		HttpResponse response = null;
		
		HttpGet getMethod = new HttpGet(url);
		try {
			response = client.execute(getMethod);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}
