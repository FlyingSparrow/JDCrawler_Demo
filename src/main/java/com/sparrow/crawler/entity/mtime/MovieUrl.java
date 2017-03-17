package com.sparrow.crawler.entity.mtime;

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
 * <p>
 * Title: MovieUrl
 * </p>
 * <p>
 * Description: 电影url信息实体类
 * </p>
 * 
 * @author wjc
 * @date 2017年2月18日
 */
@Entity
@Table(name = "t_movie_url")
public class MovieUrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -527626754618374873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "prmovie_id", unique = false, nullable = false)
	private String prmovieId;// 电影预告片id
	@Column(name = "movie_id", unique = false, nullable = false)
	private String movieId;// 电影id
	@Column(name = "url", unique = false, nullable = false)
	private String url;// 电影url
	@Column(name = "title", unique = false, nullable = false)
	private String title;// 电影名称
	@Column(name = "is_crawler", unique = false, nullable = true)
	private Integer isCrawler;// 爬虫是否已经抓取过数据，0：否；1：是

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrmovieId() {
		return prmovieId;
	}

	public void setPrmovieId(String prmovieId) {
		this.prmovieId = prmovieId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
