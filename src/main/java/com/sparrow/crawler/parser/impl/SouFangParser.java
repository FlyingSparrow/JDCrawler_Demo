package com.sparrow.crawler.parser.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.sparrow.crawler.entity.Book;
import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.parser.Parser;

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
		List<Address> addresses = new ArrayList<Address>();
		// 获取html文件
		Document doc = Jsoup.parse(html);
		// 获取总页数
		int sumpages = Integer.parseInt(doc.select("div[class=fanye gray6]")
				.select("span[class=txt]").text().replaceAll("\\D", ""));
		// 由于此网站，第一页和第二页等有重复的房源，有重读的id。防止有重复id出现，这里使用map
		Map<String, Integer> keymap = new HashMap<String, Integer>();
		try {
			for (int i = 1; i < sumpages; i++) {
				String everypageurl = "http://esf.hf.fang.com/house/i3" + i;
				// 这里我就直接用Jsoup请求了
				Document document;
				document = Jsoup.connect(everypageurl).timeout(50000).userAgent("bbbb").get();
				Elements elements = document.select("dl[id~=D03_?]");
				// 获取每一个子内容
				for (Element ele : elements) {
					String id = ele.select("dd[class=info rel floatr]").select("p")
							.select("a").attr("href").replaceAll("/chushou/", "")
							.replaceAll(".htm", "");
					if (!keymap.containsKey(id)) {
						keymap.put(id, 1);
						String url = "http://esf.hf.fang.com/" + ele.select("dd[class=info rel floatr]")
							.select("p").select("a").attr("href");
						String title = ele.select("dd[class=info rel floatr]")
								.select("p[class=title]").select("a").text();
						Date date = new Date();
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String craw_time = format.format(date);
						Address address = new Address();
						address.setAddressId(id);
						address.setAddressUrl(url);
						address.setCrawTime(craw_time);
						address.setTitle(title);
						addresses.add(address);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取拼接地址

		return addresses;
	}

}
