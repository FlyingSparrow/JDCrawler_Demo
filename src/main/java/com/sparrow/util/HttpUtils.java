package com.sparrow.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.sparrow.constants.SysConst;

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
	
	public static String getRawHtml(String url) {
		String result = null;
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpEntity httpEntity = null;
		try {
			HttpGet getMethod = new HttpGet(url);
			HttpResponse response = client.execute(getMethod);
			httpEntity = response.getEntity();
			int StatusCode = response.getStatusLine().getStatusCode();
			if (StatusCode == 200) {
				result = EntityUtils.toString(httpEntity, SysConst.ENCODING_UTF_8);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String getRawHtml(HttpClient httpclient, String url) {
		String result = null;
		
		HttpEntity httpEntity = null;
		try {
			HttpGet getMethod = new HttpGet(url);
			HttpResponse response = httpclient.execute(getMethod);
			httpEntity = response.getEntity();
			int StatusCode = response.getStatusLine().getStatusCode();
			if (StatusCode == 200) {
				result = EntityUtils.toString(httpEntity, SysConst.ENCODING_UTF_8);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
