package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements Serializable{

	@Column(name = "customer_id")
	private long CustomerId;
	@Column(name = "event_id")
	private long EventId;
	public ParticipationId(long customerId, long eventId) {
		super();
		CustomerId = customerId;
		EventId = eventId;
	}
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	public long getEventId() {
		return EventId;
	}
	public void setEventId(long eventId) {
		EventId = eventId;
	}
	public ParticipationId() {
		super();
	}
}
