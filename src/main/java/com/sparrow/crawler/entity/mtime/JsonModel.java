package com.sparrow.crawler.entity.mtime;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class JsonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4759616898306089935L;
	private String videoId;//电影片段id
	private String movieId;//电影id
	private String shortTitle;//简称
	private String prmovieId;//电影预告片id
	private String url;//电影预告片url

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
