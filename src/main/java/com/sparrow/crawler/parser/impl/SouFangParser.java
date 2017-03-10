package com.sparrow.crawler.parser.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.parser.Parser;
import com.sparrow.util.DateUtils;

/**
 * 
 * <p>
 * Title: SouFangParser
 * </p>
 * <p>
 * Description: 搜房网解析器，解析html
 * </p>
 * 
 * @author wjc
 * @date 2017年3月2日
 */
@Component
public class SouFangParser implements Parser<Address> {

	/**
	 * 
	 * <p>
	 * Description: 解析信息
	 * </p>
	 * 
	 * @param html
	 * @return
	 * @author wjc
	 * @date 2017年2月15日
	 */
	public List<Address> parse(String html) {
		List<Address> addressList = new ArrayList<Address>();
		
		try {
			// 获取html文件
			Document doc = Jsoup.parse(html);
			// 获取总页数
			int totalPages = Integer.parseInt(doc.select("div[class=fanye gray6]")
					.select("span[class=txt]").text().replaceAll("\\D", ""));
			// 由于此网站，第一页和第二页等有重复的房源，有重读的id。防止有重复id出现，这里使用map
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			Address address = null;
			Document document = null;
			for (int i = 1; i < totalPages; i++) {
				String everypageurl = "http://esf.hf.fang.com/house/i3" + i;
				// 这里我就直接用Jsoup请求了
				document = Jsoup.connect(everypageurl).timeout(50000).userAgent("bbbb").get();
				Elements elements = document.select("dl[id~=D03_?]");
				// 获取每一个子内容
				for (Element element : elements) {
					String id = element.select("dd[class=info rel floatr]").select("p")
							.select("a").attr("href").replaceAll("/chushou/", "")
							.replaceAll(".htm", "");
					if (map.get(id) == null) {
						map.put(id, 1);
						String url = "http://esf.hf.fang.com/" + element.select("dd[class=info rel floatr]")
							.select("p").select("a").attr("href");
						String title = element.select("dd[class=info rel floatr]")
								.select("p[class=title]").select("a").text();
						Date date = DateUtils.currentDate();
						String crawTime = com.sparrow.util.DateUtils.formatDate(
								date, DateUtils.DATE_SECOND_FORMAT);
						
						address = new Address();
						address.setAddressId(id);
						address.setAddressUrl(url);
						address.setCrawTime(crawTime);
						address.setTitle(title);
						addressList.add(address);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return addressList;
	}

}
