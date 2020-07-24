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
	
	
	public long getCommentId() {
		return CommentId;
	}
	public void setCommentId(long commentId) {
		CommentId = commentId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public List<Comment_React> getComment_Reacts() {
		return Comment_Reacts;
	}
	public void setComment_Reacts(List<Comment_React> comment_Reacts) {
		Comment_Reacts = comment_Reacts;
	}
	
}
