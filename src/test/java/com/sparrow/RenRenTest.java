package com.sparrow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

public class RenRenTest {
	
	/* 以下是模拟登陆程序 */
	/* 输入你的用户名及密码 ，这里输入 */
	private static String userName = "";
	private static String password = "";
	// Don't change the following URL
	private static String renRenLoginURL = "http://www.renren.com/PLogin.do";
	// The HttpClient is used in one session
	private HttpResponse response;
	private CloseableHttpClient httpclient = HttpClients.createDefault();

	/* 输入抓包的参数，即传递的参数 */
	private boolean login() {
		HttpPost httpost = new HttpPost(renRenLoginURL);
		// All the parameters post to the web site
		// 建立一个NameValuePair数组，用于存储欲传送的参数，添加相关参数，见上图中的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("domain", "renren.com"));
		nvps.add(new BasicNameValuePair("isplogin", "true"));
		nvps.add(new BasicNameValuePair("submit", "登录"));
		nvps.add(new BasicNameValuePair("email", userName));
		nvps.add(new BasicNameValuePair("password", password));
		try {
			/* 登陆成功，获取返回的数据，即html文件 */
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			response = httpclient.execute(httpost);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpost.abort();
		}
		return false;
	}

	private String getRedirectLocation() {
		/* 获取响应的头 url */
		Header locationHeader = response.getFirstHeader("Location");
		if (locationHeader == null) {
			return null;
		}
		return locationHeader.getValue();
	}

	/* 获取html文本 */
	private String getText(String redirectLocation) {
		HttpGet httpget = new HttpGet(redirectLocation);
		// Create a response handler
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String responseBody = "";
		try {
			responseBody = httpclient.execute(httpget, responseHandler);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseBody;
	}

	public void printText() {
		/* 如果注册成功了，输入相应后的html */
		if (login()) {
			String redirectLocation = getRedirectLocation();
			if (redirectLocation != null) {
				System.out.println(getText(redirectLocation));
			}
		}
	}
	
	@Test
	public void testRenrenLogin(){
		printText();
	}
}
