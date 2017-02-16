package com.sparrow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sparrow.base.BaseTests;
import com.sparrow.constants.SysConst;
import com.sparrow.crawler.entity.AutohomeUser;
import com.sparrow.crawler.parser.impl.AutohomeUserParser;
import com.sparrow.util.HttpUtils;
import com.sparrow.util.MD5;

public class AutohomeTest extends BaseTests {

	@Autowired
	private AutohomeUserParser parser;
	private CloseableHttpClient httpclient = HttpClients.createDefault();

	/*
	 * 这里是模拟登陆的过程
	 */
	private boolean login() {
		String AutohomeRenLoginURL = "http://account.autohome.com.cn/Login/ValidIndex";
		/*
		 * 用户名及密码 在我们抓包的过程中，我们发现我们的密码，被MD5加密了，所以这里有一个将密码，转换成MD5的形式
		 */
		String userName = "十七岁的雨季1";
		String password = MD5.GetMD5Code("a888888");
		HttpPost httpost = new HttpPost(AutohomeRenLoginURL);
		/*
		 * 建立一个NameValuePair数组，用于存储欲传送的参数 不明白这里参数的，请看我前面写的一篇关于模拟登陆网络抓包的的博客
		 */
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("domain", "autohome.com.cn"));
		nvps.add(new BasicNameValuePair("isauto", "true"));
		nvps.add(new BasicNameValuePair("method", "post"));
		nvps.add(new BasicNameValuePair("name", userName));
		nvps.add(new BasicNameValuePair("pwd", password));
		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, SysConst.ENCODING_UTF_8));
			httpclient.execute(httpost);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Test
	public void testFetchAutohomeUserWithCrawler() {
		try {
			if (login()) {
				/**
				 * 注意：必须使用同一个HttpClient对象，因为在执行下面的请求时，
				 * 需要保证当前的用户处于已经登录的状态，否则将会被重定向到登录页面，
				 * 导致获取不到数据
				 */
				String url = "http://i.autohome.com.cn/7741675/info";
				String html = HttpUtils.getRawHtml(httpclient, url);
				List<AutohomeUser> authorInfo = parser.parse(html);
				for (AutohomeUser user : authorInfo) {
					logger.info("用户信息：{}", JSON.toJSONString(user));
					logger.info("ID: {}，Birthday: {}，Age: {}，Area: {}", 
							user.getAuthorId(), user.getBirthday(),
							user.getAge(), user.getArea());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
