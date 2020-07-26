package com.consommi.tounsi.models;


import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType",discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	private String UserName;
	private String Password;
	private Date Blocked ;
	@Transient
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@OneToMany(mappedBy = "User", fetch = FetchType.EAGER)
	private List<Post_React> Post_Reacts;
	@OneToMany(mappedBy = "User")
	private List<Comment_React> Comment_Reacts;
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@JsonIgnore
	public List<Post_React> getPost_Reacts() {
		return Post_Reacts;
	}
	public void setPost_Reacts(List<Post_React> post_Reacts) {
		Post_Reacts = post_Reacts;
	}
	@JsonIgnore
	public List<Comment_React> getComment_Reacts() {
		return Comment_Reacts;
	}
	public void setComment_Reacts(List<Comment_React> comment_Reacts) {
		Comment_Reacts = comment_Reacts;
	}
	public Date getBlocked() {
		return Blocked;
	}
	public void setBlocked(Date blocked) {
		Blocked = blocked;
	}
	
}
