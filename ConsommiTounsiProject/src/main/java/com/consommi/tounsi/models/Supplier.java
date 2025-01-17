package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Supplier")
public class Supplier extends User{

	private String Name;
	private String Mail;
	private String Address;
	private String Phone;
	private String UrlImage;
	
	public String getUrlImage() {
		return UrlImage;
	}
	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	@JsonIgnore
	public List<Event> getEvents() {
		return Events;
	}
	public void setEvents(List<Event> events) {
		Events = events;
	}
	@JsonIgnore
	public List<Stock> getStock() {
		return Stock;
	}
	public void setStock(List<Stock> stock) {
		Stock = stock;
	}
	@JsonIgnore
	public List<Ad> getAds() {
		return Ads;
	}
	public void setAds(List<Ad> ads) {
		Ads = ads;
	}
	@OneToMany(mappedBy = "Supplier")
	private List<Event> Events;
	@OneToMany(mappedBy = "Supplier")
	private List<Stock> Stock;
	@OneToMany(mappedBy = "Supplier")
	private List<Ad> Ads;
}
