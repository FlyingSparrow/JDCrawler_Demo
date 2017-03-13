package com.sparrow.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	private HttpUtils() {
	}
	
	public static String getRawHtml(String url) {
		String result = null;
		
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			result = executeWithHttpClient(client, url);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static String getRawHtml(HttpClient httpclient, String url) {
		return executeWithHttpClient(httpclient, url);
	}
	
	private static String executeWithHttpClient(HttpClient httpclient, String url){
		String result = null;
		
		HttpEntity httpEntity = null;
		try {
			HttpGet getMethod = new HttpGet(url);
			HttpResponse response = httpclient.execute(getMethod);
			httpEntity = response.getEntity();
			
			String contentEncoding = null;
			Header[] headers = response.getAllHeaders();
			for(Header item : headers){
//				logger.info("HttpRequest Header, name: [{}], value: [{}]", 
//						item.getName(), item.getValue());
				if("Content-Encoding".toLowerCase().equals(item.getName().toLowerCase())){
					contentEncoding = item.getValue();
					logger.info("contentEncoding: {}", contentEncoding);
				}
			}
			
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				result = EntityUtils.toString(httpEntity, SysConst.ENCODING_UTF_8);
				
				if(StringUtils.isNotEmpty(contentEncoding) && contentEncoding
						.toLowerCase().indexOf("gzip") != -1){
					GzipDecompressingEntity zipRes = new GzipDecompressingEntity(httpEntity);
					result = EntityUtils.toString(zipRes, SysConst.ENCODING_GB18030);
				}
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
	
	/**
	 * 执行http的post请求并返回响应结果
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(String url, Map<String, String> params) {
		String body = null;
		try {
			logger.info("create httppost: {}", url);
			
			HttpUriRequest post = buildHttpRequest(url, params);
			body = execute(post);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return body;
	}

	/**
	 * 执行http的get请求并返回响应结果
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		String body = null;
		try {
			logger.info("create httpget:" + url);
			
			HttpGet get = new HttpGet(url);
			body = execute(get);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return body;
	}
	
	/**
	 * 执行http请求并返回响应结果
	 * @param httpclient
	 * @param httpRequest
	 * @return
	 */
	private static String execute(HttpUriRequest httpRequest) {
		String body = "";
		
		CloseableHttpClient httpclient = null;
		try {
			httpclient = HttpClients.createDefault();
			
			logger.info("execute post...");
			
			HttpResponse response = httpclient.execute(httpRequest);
			body = parseResponse(response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (httpclient != null)
					httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return body;
	}

	/**
	 * 解析http请求的响应结果
	 * @param response
	 * @return
	 */
	private static String parseResponse(HttpResponse response) {
		logger.info("get response from http server..");
		HttpEntity entity = response.getEntity();

		logger.info("response status: " + response.getStatusLine());
		String contentType = entity.getContentType().toString();
		logger.info(contentType);

		String body = null;
		try {
			long start = System.currentTimeMillis();
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				body = EntityUtils.toString(entity);
			}
			long end = System.currentTimeMillis();
			logger.info("It is completed that get the entity content as a String,"
					+" and it took "+((end - start)/1000)+" seconds");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	/**
	 * 构造http请求对象
	 * @param url
	 * @param params
	 * @return
	 */
	private static HttpUriRequest buildHttpRequest(String url, Map<String, String> params) {
		HttpPost httpPost = new HttpPost(url);
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}

		logger.info("set utf-8 form entity to httppost");
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

		return httpPost;
	}

}
