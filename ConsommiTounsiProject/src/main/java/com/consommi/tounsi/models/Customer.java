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
	private String Birthday ;
	private String Phone ;
	private String Gender;
	@OneToMany(mappedBy = "Customer")
	private List<Order> Orders;
	@OneToMany(mappedBy = "Customer", fetch = FetchType.LAZY)
	private List<Participation> Participations;
	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String urlImage, String mail, String address, String birthday,
			String phone, String gender, List<Order> orders, List<Participation> participations) {
		super();
		FirstName = firstName;
		LastName = lastName;
		UrlImage = urlImage;
		Mail = mail;
		Address = address;
		Birthday = birthday;
		Phone = phone;
		Gender = gender;
		Orders = orders;
		Participations = participations;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUrlImage() {
		return UrlImage;
	}
	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public List<Order> getOrders() {
		return Orders;
	}
	public void setOrders(List<Order> orders) {
		Orders = orders;
	}
	public List<Participation> getParticipations() {
		return Participations;
	}
	public void setParticipations(List<Participation> participations) {
		Participations = participations;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
	
}
