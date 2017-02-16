package com.sparrow.crawler.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sparrow.crawler.entity.AutohomeUser;
import com.sparrow.crawler.parser.Parser;
import com.sparrow.util.DateUtils;

/**
 * 
 * <p>
 * Title: JDParser
 * </p>
 * <p>
 * Description: 汽车之家用户信息解析器，解析html
 * </p>
 * 
 * @author wjc
 * @date 2017年2月15日
 */
@Component
public class AutohomeUserParser implements Parser<AutohomeUser> {

	/**
	 * 
	 * <p>
	 * Description: 解析汽车之家的用户信息
	 * </p>
	 * 
	 * @param html
	 * @return
	 * @author wjc
	 * @param httpclient 
	 * @date 2017年2月15日
	 */
	@Override
	public List<AutohomeUser> parse(String html) {
		List<AutohomeUser> result = new ArrayList<AutohomeUser>();

		Document doc = Jsoup.parse(html);
		
		AutohomeUser user = new AutohomeUser();
		String authorId = "autohome" + doc.select("li[class=current]")
			.select("a").attr("href").replaceAll("\\D", "");
		String source = "autohome";
		String crawTime = DateUtils.formatDate(DateUtils.currentDate(), 
				DateUtils.DATE_SECOND_FORMAT);
		Elements elements = doc.select("div[class=uData]").select("p");
		for (Element element : elements) {
			if (element.text().contains("所在地")) {
				user.setArea(getText(element));
			}
			if (element.text().contains("性别")) {
				user.setGender(getText(element));
			}
			if (element.text().contains("生日")) {
				String birthday = getText(element);
				if(StringUtils.isNotEmpty(birthday)){
					String age = DateUtils.getAgeFromBirth(birthday);
					user.setAge(age);
				}
				user.setBirthday(birthday);
			}
			if (element.text().contains("用户名")) {
				user.setAuthorName(getText(element));
			}
		}
		user.setAuthorId(authorId);
		user.setSource(source);
		user.setCrawTime(crawTime);
		result.add(user);
		
		return result;
	}
	
	private String getText(Element element){
		if(element == null){
			return "";
		}
		String result = element.text().replaceAll(Jsoup.parse("&nbsp;").text(), "").split(":")[1];
		
		return result;
	}

}
