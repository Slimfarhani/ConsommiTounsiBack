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
}
