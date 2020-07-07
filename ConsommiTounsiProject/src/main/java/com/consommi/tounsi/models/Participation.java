package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	private boolean IsParticipating;
	private float DonationAmount;
}
