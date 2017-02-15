package com.sparrow.crawler.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sparrow.crawler.entity.Book;
import com.sparrow.util.DateUtils;

/**
 * 
 * <p>Title: JDParser</p>
 * <p>Description: 京东解析器，解析html</p>
 * @author wjc
 * @date 2017年2月15日
 */
@Component
public class JdParser {

	/**
	 * 
	 * <p>Description: 解析京东的图书信息</p>
	 * @param html
	 * @return
	 * @author wjc
	 * @date 2017年2月15日
	 */
	public List<Book> parseBook(String html) {
		List<Book> result = new ArrayList<Book>();

		Date currentDate = DateUtils.currentDate();
		String userAccount = "wjc";
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
		for (Element element : elements) {
			String bookId = element.attr("data-sku");
			String bookPrice = element.select("div[class=p-price]").select("strong")
					.select("i").text();
			String bookName = element.select("div[class=p-name]").select("em").text();

			Book book = new Book();
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setBookPrice(Double.valueOf(bookPrice));
			book.setCreateDate(currentDate);
			book.setCreateUser(userAccount);
			book.setUpdateDate(currentDate);
			book.setUpdateUser(userAccount);
			
			result.add(book);
		}

		return result;
	}
	
}
