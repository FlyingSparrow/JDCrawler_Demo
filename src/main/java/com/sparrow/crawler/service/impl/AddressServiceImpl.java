package com.sparrow.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparrow.crawler.entity.soufang.Address;
import com.sparrow.crawler.repository.AddressRepository;
import com.sparrow.crawler.service.AddressService;

/**
 * 
 * <p>Title: BookServiceImpl</p>
 * <p>Description: 房源信息的业务层接口实现类</p>
 * @author wjc
 * @date 2017年2月14日
 */
@Transactional
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address findByAddressId(String addressId) {
		return addressRepository.findByAddressId(addressId);
	}

	@Override
	public boolean batchAddAddress(List<Address> list) {
		addressRepository.save(list);
		return true;
	}

	@Override
	public boolean isExist(String addressId) {
		Address address = addressRepository.findByAddressId(addressId);
		
		return (address != null);
	}

}
