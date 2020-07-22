package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Comment_ReactId implements Serializable{

	@Column(name = "comment_id")
	private long CommentId;
	@Column(name = "user_id")
	private long UserId;
	public long getCommentId() {
		return CommentId;
	}
	
	public Comment_ReactId() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Comment_ReactId(long commentId, long userId) {
		super();
		CommentId = commentId;
		UserId = userId;
	}

	public void setCommentId(long commentId) {
		CommentId = commentId;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	
	
}
