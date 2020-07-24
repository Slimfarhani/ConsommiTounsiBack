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
	public Delivery_Man() {
		super();
	}
	public long getDelivery_ManId() {
		return Delivery_ManId;
	}
	public void setDelivery_ManId(long delivery_ManId) {
		Delivery_ManId = delivery_ManId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public DeliveryZone getDeliveryZone() {
		return DeliveryZone;
	}
	public void setDeliveryZone(DeliveryZone deliveryZone) {
		DeliveryZone = deliveryZone;
	}
	public List<Delivery> getDeliveries() {
		return Deliveries;
	}
	public void setDeliveries(List<Delivery> deliveries) {
		Deliveries = deliveries;
	}
	private String Name;
	private String State;
	@Enumerated(EnumType.STRING)
	private DeliveryZone DeliveryZone;
	@OneToMany(mappedBy = "Delivery_Man")
	private List<Delivery> Deliveries;
}
