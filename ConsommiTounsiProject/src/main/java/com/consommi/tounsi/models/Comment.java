package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long CommentId;
	private String Content;
	@ManyToOne
	private User User;
	@ManyToOne
	private Post Post;
	@OneToMany(mappedBy = "Comment")
	private List<Comment_React> Comment_Reacts;
	
}
