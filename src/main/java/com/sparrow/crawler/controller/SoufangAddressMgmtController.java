package com.sparrow.crawler.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparrow.base.controller.BaseController;
import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.service.AddressService;
import com.sparrow.framework.beans.AjaxResult;

/**
 * 
 * <p>Title: SoufangAddressMgmtController</p>
 * <p>Description: 房源信息管理的控制器</p>
 * @author wjc
 * @date 2017年3月10日
 */
@RestController
@RequestMapping(value="/soufang")
public class SoufangAddressMgmtController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SoufangAddressMgmtController.class);
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * 
	 * <p>Description: 批量添加房源</p>
	 * @param list
	 * @return
	 * @author wjc
	 * @date 2017年2月15日
	 */
	@RequestMapping("/batchAddAddress")
	public AjaxResult batchAddAddress(@RequestBody List<Address> list){
		try {
			if(list != null){
				List<Address> newList = getDistinctAddressList(list);
				addressService.batchAddAddress(newList);
				return success("success");
			}else{
				return fail("房源信息不能为空");
			}
		} catch (Exception e) {
			logger.error("批量添加房源出错，房源信息: {}，异常信息：{}", list, e);
		}
		return fail("批量添加房源失败，请重试");
	}
	
	private List<Address> getDistinctAddressList(List<Address> list){
		List<Address> result = new ArrayList<Address>();
		if(list != null){
			for(Address item : list){
				if(!addressService.isExist(item.getAddressId())){
					result.add(item);
				}
			}
		}
		
		return result;
	}
	
}
