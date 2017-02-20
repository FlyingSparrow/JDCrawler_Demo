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
 * Title: MovieComment
 * </p>
 * <p>
 * Description: 电影评论信息实体类
 * </p>
 * 
 * @author wjc
 * @date 2017年2月18日
 */
@Entity
@Table(name = "t_movie_comment")
public class MovieComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -527626754618374873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "comment_id", unique = false, nullable = false)
	private String commentId;// 电影评论id
	@Column(name = "prmovie_id", unique = false, nullable = false)
	private String prmovieId;// 电影预告片id
	@Column(name = "comment", unique = false, nullable = true)
	private String comment;// 电影评论
	@Column(name = "time", unique = false, nullable = false)
	private String time;// 评论时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
