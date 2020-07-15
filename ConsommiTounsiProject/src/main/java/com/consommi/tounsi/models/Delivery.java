package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long DeliveryId;
	private String DeliveryMethod;
	private float Weight;
	private String Address;
	private Date DeliveryDate;
	private String State;
	private float Rating;
	@ManyToOne
	private Delivery_Man Delivery_Man;
}
