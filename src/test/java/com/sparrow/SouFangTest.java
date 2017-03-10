package com.sparrow;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.parser.impl.SouFangParser;
import com.sparrow.util.FileUtils;
import com.sparrow.util.HttpUtils;

/**
 * 
 * <p>Title: SouFangTest</p>
 * <p>Description:单元测试类</p>
 * @author wjc
 * @date 2017年2月14日
 */
public class SouFangTest extends BaseTests {

	@Autowired
	private SouFangParser souFangParser;
	
	@Test
	public void testBatchAddAddress(){
		String addressInfoUrl = "http://esf.hf.fang.com/";
		String rawHtml = HttpUtils.getRawHtml(addressInfoUrl);
		List<Address> list = souFangParser.parse(rawHtml);
		list.forEach(item -> {
			logger.info("address: {}", item);
		});
		String url = "/soufang/batchAddAddress";
		String response = performAndGetResponse(url, list);
		logger.info("批量添加房源，执行结果：{}", response);
	}
	
	@Test
	public void testFetchAddressInfo(){
		String addressInfoUrl = "http://esf.hf.fang.com/";
		String rawHtml = HttpUtils.getRawHtml(addressInfoUrl);
		FileUtils.writeFile(new File("E:/soufang/soufang_hf.html"), rawHtml);
		List<Address> list = souFangParser.parse(rawHtml);
		list.forEach(item -> {
			logger.info("address: {}", item);
		});
	}
	
}
