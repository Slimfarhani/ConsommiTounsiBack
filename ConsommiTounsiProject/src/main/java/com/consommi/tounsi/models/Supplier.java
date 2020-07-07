package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Supplier extends User{

	private String Name;
	private String Mail;
	private String Address;
	@OneToMany(mappedBy = "Supplier")
	private List<Event> Events;
	@OneToMany(mappedBy = "Supplier")
	private List<Stock> Stock;
	@OneToMany(mappedBy = "Supplier")
	private List<Ad> Ads;
}
