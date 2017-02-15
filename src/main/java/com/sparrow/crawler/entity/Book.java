package com.sparrow.crawler.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * <p>
 * Title: Book
 * </p>
 * <p>
 * Description: 图书信息实体类
 * </p>
 * 
 * @author wjc
 * @date 2017年2月14日
 */
@Entity
@Table(name = "t_book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -527626754618374873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "book_id", unique = false, nullable = false)
	private String bookId;// 图书id
	@Column(name = "book_name", unique = false, nullable = false)
	private String bookName;// 图书名称
	@Column(name = "book_price", unique = false, nullable = false)
	private Double bookPrice;// 图书价格
	@Column(name = "create_date", unique = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate; // 创建时间
	@Column(name = "create_user", unique = false, nullable = false)
	private String createUser;// 创建人
	@Column(name = "update_date", unique = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;// 更新时间
	@Column(name = "update_user", unique = false, nullable = false)
	private String updateUser;// 更新人

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
