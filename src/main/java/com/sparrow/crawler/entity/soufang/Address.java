package com.sparrow.crawler.entity.soufang;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Title: Address</p>
 * <p>Description: 房屋信息实体类</p>
 * @author wjc
 * @date 2017年3月9日
 */
@Entity
@Table(name = "t_soufang_address")
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8467345963375152885L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "address_id", unique = false, nullable = false)
	private String addressId;//房源id
	@Column(name = "address_url", unique = false, nullable = false)
	private String addressUrl;//房源url
	@Column(name = "title", unique = false, nullable = false)
	private String title;//房源标题
	@Column(name = "craw_time", unique = false, nullable = false)
	private String crawTime;//抓取时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressUrl() {
		return addressUrl;
	}

	public void setAddressUrl(String addressUrl) {
		this.addressUrl = addressUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCrawTime() {
		return crawTime;
	}

	public void setCrawTime(String crawTime) {
		this.crawTime = crawTime;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
