package com.sparrow.crawler.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sparrow.constants.SysConst;
import com.sparrow.crawler.entity.Book;
import com.sparrow.util.HttpUtils;

/**
 * 
 * <p>Title: UrlParser</p>
 * <p>Description: URL解析器，解析url</p>
 * @author wjc
 * @date 2017年2月15日
 */
@Component
public class UrlParser {
	
	@Autowired
	private JdParser parser;

	public List<Book> parseUrl(HttpClient client, String url) {
		List<Book> result = new ArrayList<Book>();

		HttpResponse response = HttpUtils.getRawHtml(client, url);
		HttpEntity httpEntity = response.getEntity();
		try {
			int StatusCode = response.getStatusLine().getStatusCode();
			if (StatusCode == 200) {
				String entity = EntityUtils.toString(httpEntity, SysConst.ENCODING_UTF_8);

				result = parser.parseBook(entity);
			}
		} catch (Exception e) {
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
