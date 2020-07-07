package com.consommi.tounsi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PostId;
	private String Title;
	private String Content;
	private int RatingTotal;
	private int RatingNumber;
}
