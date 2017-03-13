package com.sparrow;

import java.io.File;
import java.util.List;

import javax.persistence.Column;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparrow.base.BaseTests;
import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.entity.soufang.AddressDetails;
import com.sparrow.crawler.parser.impl.SouFangAddressDetailsParser;
import com.sparrow.crawler.parser.impl.SouFangAddressParser;
import com.sparrow.util.FileUtils;
import com.sparrow.util.HttpUtils;

/**
 * 
 * <p>Title: SouFangTest</p>
 * <p>Description: 单元测试类</p>
 * @author wjc
 * @date 2017年2月14日
 */
public class SouFangTest extends BaseTests {

	@Autowired
	private SouFangAddressParser souFangParser;
	@Autowired
	private SouFangAddressDetailsParser souFangAddressDetailsParser;
	
	/**
	 * 
	 * <p>Description: 测试批量添加房源信息</p>
	 * @author wjc
	 * @date 2017年3月11日
	 */
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
	
	/**
	 * 
	 * <p>Description: 测试抓取房源信息</p>
	 * @author wjc
	 * @date 2017年3月11日
	 */
	@Test
	public void testFetchAddressInfo(){
		String url = "http://esf.hf.fang.com/";
		String rawHtml = HttpUtils.getRawHtml(url);
		FileUtils.writeFile(new File("E:/soufang/soufang_hf.html"), rawHtml);
		List<Address> list = souFangParser.parse(rawHtml);
		list.forEach(item -> {
			logger.info("address: {}", item);
		});
	}
	
	/**
	 * 
	 * <p>Description: 测试抓取房源详细信息</p>
	 * @author wjc
	 * @date 2017年3月11日
	 */
	@Test
	public void testFetchAddressDetailsInfo(){
		String url = "http://esf.hf.fang.com//chushou/3_248573434.htm";
		String rawHtml = HttpUtils.getRawHtml(url);
		try {
//			private String publishTime;//发布时间
//			private String price;//总价/价格
//			private String houseType;//户型
//			private String acreage;//面积（建筑面积）
//			private String useAcreage;//使用面积（使用面积=建筑面积X（1-0.23），计算结果为估算值，不是精确值）
//			private String years;//年代
//			private String orientation;//朝向
//			private String floor;//楼层
//			private String structure;//建筑结构
//			private String decoration;//装修情况
//			private String type;//住宅类型
//			private String buildingType;//建筑类型
//			private String propertyRight;//产权性质
//			private String estate;//房地产开发商
//			private String school;//学校
//			private String facilities;//房屋设施
			
			
			Document doc = Jsoup.parse(rawHtml);
			String title = doc.select("div[class=mainBoxL]").select("div[class=title]")
				.select("h1").text();
			logger.info("title: {}", title);
			
			String info = doc.select("div[class=mainBoxL]").select("div[class=title]")
					.select("p").text();
			String publishTime = "";
			if(info.indexOf("发布时间：") != -1){
				publishTime = info.substring(info.indexOf("发布时间：")+5);
			}
			logger.info("publishTime: {}", publishTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		FileUtils.writeFile(new File("E:/soufang/soufang_hf.html"), rawHtml);
//		List<AddressDetails> list = souFangAddressDetailsParser.parse(rawHtml);
//		list.forEach(item -> {
//			logger.info("address: {}", item);
//		});
	}
	
}
