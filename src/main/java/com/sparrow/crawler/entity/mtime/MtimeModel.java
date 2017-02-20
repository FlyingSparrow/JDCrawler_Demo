package com.sparrow.crawler.entity.mtime;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MtimeModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3455179846073572201L;
	private String prmovieId;//电影预告片id
	private String movieId;//电影id
	private String url;//电影预告片url
	private String title;//电影预告片名称

	public String getPrmovieId() {
		return prmovieId;
	}

	public void setPrmovieId(String prmovieId) {
		this.prmovieId = prmovieId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
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
