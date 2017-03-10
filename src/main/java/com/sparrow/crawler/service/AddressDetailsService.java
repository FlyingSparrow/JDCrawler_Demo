package com.sparrow.crawler.service;

import java.util.List;

import com.sparrow.crawler.entity.soufang.AddressDetails;

public interface AddressDetailsService {
	
	boolean isExist(String addressId);
	
	AddressDetails findByAddressId(String addressId);
	
	boolean batchAddAddress(List<AddressDetails> list);
	
}
