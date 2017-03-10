package com.sparrow.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sparrow.crawler.entity.soufang.Address;

/**
 * 
 * <p>Title: AddressRepository</p>
 * <p>Description: 房源信息的数据库操作接口</p>
 * @author wjc
 * @date 2017年3月10日
 */
public interface AddressRepository extends JpaSpecificationExecutor<Address>, 
	JpaRepository<Address, Long>, PagingAndSortingRepository<Address, Long> {

	Address findByAddressId(String addressId);
}
