package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.consommi.tounsi.enumerations.Reaction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Post_React {

	@EmbeddedId
	private Post_ReactId Post_ReactId;
	@Enumerated(EnumType.STRING)
	private Reaction ReactionType;
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User User;
	@ManyToOne
	@MapsId("post_id")
	@JoinColumn(name = "post_id")
	private Post Post;
	public Post_ReactId getPost_ReactId() {
		return Post_ReactId;
	}
	public void setPost_ReactId(Post_ReactId post_ReactId) {
		Post_ReactId = post_ReactId;
	}
	public Reaction getReactionType() {
		return ReactionType;
	}
	public void setReactionType(Reaction reactionType) {
		ReactionType = reactionType;
	}
	@JsonIgnore
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	@JsonIgnore
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public Post_React() {
		super();
	}
}
