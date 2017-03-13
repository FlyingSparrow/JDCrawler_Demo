package com.sparrow.crawler.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.sparrow.crawler.entity.soufang.AddressDetails;
import com.sparrow.crawler.parser.Parser;

/**
 * 
 * <p>
 * Title: SouFangAddressDetailsParser
 * </p>
 * <p>
 * Description: 房源详细信息解析器，解析html
 * </p>
 * 
 * @author wjc
 * @date 2017年3月10日
 */
@Component
public class SouFangAddressDetailsParser implements Parser<AddressDetails> {

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
	public List<AddressDetails> parse(String html) {
		List<AddressDetails> result = new ArrayList<AddressDetails>();
		
		try {
			Document doc = Jsoup.parse(html);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
