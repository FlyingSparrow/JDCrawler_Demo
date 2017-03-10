package com.sparrow.crawler.repository;

import org.springframework.data.repository.CrudRepository;

import com.sparrow.crawler.entity.soufang.AddressDetails;

/**
 * 
 * <p>Title: AddressRepository</p>
 * <p>Description: 房源信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年3月10日
 */
public interface AddressDetailsRepository extends CrudRepository<AddressDetails, Long> {

	AddressDetails findByAddressId(String addressId);
}
