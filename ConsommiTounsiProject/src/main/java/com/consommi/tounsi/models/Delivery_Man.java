package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.consommi.tounsi.enumerations.DeliveryZone;

@Entity
public class Delivery_Man {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Delivery_ManId;
	private String Name;
	private String State;
	@Enumerated(EnumType.STRING)
	private DeliveryZone DeliveryZone;
	@OneToMany(mappedBy = "Delivery_Man")
	private List<Delivery> Deliveries;
}
