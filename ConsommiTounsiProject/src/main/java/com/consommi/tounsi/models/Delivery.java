package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DeliveryId;
	private String DeliveryMethod;
	private float Weight;
	private String Address;
	private Date DeliveryDate;
	private String State;
	private float Rating;
}
