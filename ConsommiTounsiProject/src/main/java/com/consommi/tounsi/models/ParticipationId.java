package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements Serializable{

	@Column(name = "customer_id")
	private int CustomerId;
	@Column(name = "event_id")
	private int EventId;
}
