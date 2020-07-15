package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends User{

	private String FirstName;
	private String LastName;
	private String UrlImage;
	private String Mail;
	private String Address;
	@OneToMany(mappedBy = "Customer")
	private List<Order> Orders;
	@OneToMany(mappedBy = "Customer", fetch = FetchType.LAZY)
	private List<Participation> Participations;
	
	
}
