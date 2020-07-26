package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participation {

	@EmbeddedId
	private ParticipationId ParticipationId;
	@ManyToOne
	@MapsId("customer_id")
	@JoinColumn(name = "customer_id")
	private Customer Customer;
	@ManyToOne
	@MapsId("event_id")
	@JoinColumn(name = "event_id")
	private Event Event;
	//private boolean IsParticipating;
	private float DonationAmount;
	
	
	public ParticipationId getParticipationId() {
		return ParticipationId;
	}
	public void setParticipationId(ParticipationId participationId) {
		ParticipationId = participationId;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	@JsonIgnore
	public Event getEvent() {
		return Event;
	}
	public void setEvent(Event event) {
		Event = event;
	}

	public float getDonationAmount() {
		return DonationAmount;
	}
	public void setDonationAmount(float donationAmount) {
		DonationAmount = donationAmount;
	}
}
