package com.sparrow.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.soufang.AddressDetails;
import com.sparrow.crawler.repository.AddressDetailsRepository;
import com.sparrow.crawler.service.AddressDetailsService;

/**
 * 
 * <p>Title: BookServiceImpl</p>
 * <p>Description: 房源信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月14日
 */
@Transactional
@Service
public class AddressDetailsServiceImpl implements AddressDetailsService {

	@Autowired
	private AddressDetailsRepository addressDetailsRepository;

	@Override
	public boolean isExist(String addressId) {
		AddressDetails details = addressDetailsRepository.findByAddressId(addressId);
		
		return (details != null);
	}

	@Override
	public AddressDetails findByAddressId(String addressId) {
		return addressDetailsRepository.findByAddressId(addressId);
	}

	@Override
	public boolean batchAddAddress(List<AddressDetails> list) {
		addressDetailsRepository.save(list);
		return true;
	}

}
