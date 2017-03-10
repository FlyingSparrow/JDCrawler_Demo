package com.sparrow.crawler.service;

import java.util.List;

import com.sparrow.crawler.entity.soufang.Address;

public interface AddressService {
	
	boolean isExist(String addressId);
	
	Address findByAddressId(String addressId);
	
	boolean batchAddAddress(List<Address> list);
	
}
