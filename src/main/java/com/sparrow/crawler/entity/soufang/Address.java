package com.sparrow.crawler.entity.soufang;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {
	private String addressId;
	private String addressUrl;
	private String title;
	private String crawTime;

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
