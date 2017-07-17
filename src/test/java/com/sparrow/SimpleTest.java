package com.sparrow;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sparrow.constants.SysConst;
import com.sparrow.util.HttpUtils;

public class SimpleTest {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testHttpClientWithPost() {
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			String url = "http://www.autohome.com.cn/beijing/";
			HttpPost postMethod = new HttpPost(url);
			logger.info("postMethod: {}", postMethod);

			HttpResponse response = client.execute(postMethod);
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info("StatusCode: {}", statusCode);
			logger.info("response: {}", response);
			if (statusCode == 200) {
				String entity = EntityUtils.toString(response.getEntity(), SysConst.ENCODING_UTF_8);
				logger.info("response result: {}", entity);
				EntityUtils.consume(response.getEntity());
			} else {
				EntityUtils.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testHttpClientWithGet() {
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
//			String url = "http://cxcyfw.com/contents/23/4184.html";
			String url = "http://www.cxcyfw.com/contents/4/5036.html";
			HttpGet getMethod = new HttpGet(url);
			logger.info("postMethod: {}", getMethod);

			HttpResponse response = client.execute(getMethod);
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info("StatusCode: {}", statusCode);
			logger.info("response: {}", response);
			if (statusCode == 200) {
				String entity = EntityUtils.toString(response.getEntity(), SysConst.ENCODING_UTF_8);
//				logger.info("response result: {}", entity);
				String selectorName = "class";
				String selectorValue = "TRS_Editor";
				String textContent = getTextFromHTML(entity, selectorName, selectorValue);
				logger.info("textContent: {}", textContent);
				System.out.println(textContent);
				EntityUtils.consume(response.getEntity());
			} else {
				EntityUtils.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * <p>Description: 从html内容中获取去除html标签以后的文本内容</p>
	 * @param htmlStr
	 * @return
	 * @author wjc
	 * @date 2017年5月4日
	 */
	public String getTextFromHTML(String htmlStr, String selectorKey, 
			String selectorValue) {
		if(htmlStr == null || htmlStr.trim().equals("")){
			return "";
		}
		Document doc = Jsoup.parse(htmlStr);
		String text = doc.getElementsByAttributeValue(selectorKey, selectorValue).text();
		// remove extra white space
		StringBuilder builder = new StringBuilder(text);
		int index = 0;
		while (builder.length() > index) {
			char tempChar = builder.charAt(index);
			if (Character.isSpaceChar(tempChar) || Character.isWhitespace(tempChar)) {
				builder.setCharAt(index, ' ');
			}
			index++;
		}
		text = builder.toString().replaceAll(" +", " ").trim();
		return text;
	}

	@Test
	public void testJsoup() {
		parseHtmlStr();

		Document doc = null;
		try {
			String url = "http://www.tripadvisor.com/SearchForums?q=airbnb&x=18&y=10&pid=34633&s=+";
			doc = Jsoup.connect(url).userAgent("bbb").timeout(50000).get();
			Elements elements = doc.select("table[class=forumsearchresults]").select("tr[class~=firstpostrow?]");
			for (Element element : elements) {
				String _id = element.attr("id");
				String _url = "http://www.tripadvisor.com"
						+ element.select("td[onclick~=setPID?]").select("a").attr("href");
				String _content = element.select("td[onclick~=setPID?]").select("a").text();
				logger.info("id: {}, url: {}, content: {}", _id, _url, _content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <p>
	 * Description: 解析一个html字符串
	 * </p>
	 * 
	 * @author wjc
	 * @date 2017年2月15日
	 */
	private void parseHtmlStr() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		logger.info("doc: \n{}", doc);
	}
	
	@Test
	public void testHttpClient2(){
		String url = "http://esf.hf.fang.com/";
		String result = HttpUtils.getRawHtml(url);
		logger.info("result: {}", result);
	}
	
	@Test
	public void testHttpClient3(){
		String url = "http://cxcyfw.com/contents/23/4184.html";
		String result = HttpUtils.getRawHtml(url);
		logger.info("result: {}", result);
	}

}
