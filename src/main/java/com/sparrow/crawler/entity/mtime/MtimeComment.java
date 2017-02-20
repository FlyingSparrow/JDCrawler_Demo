package com.sparrow.crawler.entity.mtime;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MtimeComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6781850246573321045L;
	private String commentId;//评论id
	private String prmovieId;//电影预告片id
	private String comment;//评论
	private String time;//评论时间

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getPrmovieId() {
		return prmovieId;
	}

	public void setPrmovieId(String prmovieId) {
		this.prmovieId = prmovieId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
