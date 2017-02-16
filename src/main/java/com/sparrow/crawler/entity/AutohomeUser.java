package com.sparrow.crawler.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Title: AutohomeUser</p>
 * <p>Description: 汽车之家用户信息的实体类</p>
 * @author wjc
 * @date 2017年2月16日
 */
public class AutohomeUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -842424800104568625L;
	
	private String authorId;
    private String authorName;
    private String birthday;
    private String age;
    private String gender;
    private String area;
    private String source;
    private String crawTime;
    
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
