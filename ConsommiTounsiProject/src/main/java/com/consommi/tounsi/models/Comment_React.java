package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.consommi.tounsi.enumerations.Reaction;

@Entity
public class Comment_React {

	@EmbeddedId
	private Comment_ReactId Comment_ReactId;
	@Enumerated(EnumType.STRING)
	private Reaction ReactionType;
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User User;
	@ManyToOne
	@MapsId("comment_id")
	@JoinColumn(name = "comment_id")
	private Comment Comment;

}
