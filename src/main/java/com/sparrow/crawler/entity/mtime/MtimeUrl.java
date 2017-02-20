package com.sparrow.crawler.entity.mtime;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MtimeUrl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5916067443183715077L;
	private String id;// 电影的id
	private String url;// 电影的url

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
