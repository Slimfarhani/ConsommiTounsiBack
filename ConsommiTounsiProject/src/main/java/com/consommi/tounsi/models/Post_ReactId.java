package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Post_ReactId implements Serializable {

	@Column(name = "post_id")
	private long PostId;
	@Column(name = "user_id")
	private long UserId;
	@JsonIgnore
	public long getPostId() {
		return PostId;
	}
	public void setPostId(long postId) {
		PostId = postId;
	}
	@JsonIgnore
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public Post_ReactId(long postId, long userId) {
		super();
		PostId = postId;
		UserId = userId;
	}
	public Post_ReactId() {
		super();
	}
}
