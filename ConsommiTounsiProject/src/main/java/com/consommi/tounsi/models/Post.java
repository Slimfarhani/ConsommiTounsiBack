package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long PostId;
	private String Title;
	private String Content;
	private int RatingTotal;
	private int RatingNumber;
	@ManyToOne
	private User User;
	@OneToMany(mappedBy = "Post")
	private List<Post_React> Post_Reacts;
	public long getPostId() {
		return PostId;
	}
	public void setPostId(long postId) {
		PostId = postId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getRatingTotal() {
		return RatingTotal;
	}
	public void setRatingTotal(int ratingTotal) {
		RatingTotal = ratingTotal;
	}
	public int getRatingNumber() {
		return RatingNumber;
	}
	public void setRatingNumber(int ratingNumber) {
		RatingNumber = ratingNumber;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public List<Post_React> getPost_Reacts() {
		return Post_Reacts;
	}
	public void setPost_Reacts(List<Post_React> post_Reacts) {
		Post_Reacts = post_Reacts;
	}
}
