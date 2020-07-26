package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.consommi.tounsi.enumerations.DeliveryManStat;
import com.consommi.tounsi.enumerations.DeliveryZone;

@Entity
public class Delivery_Man {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Delivery_ManId;
	
	private String Name;
	private String NumTel;
	@Enumerated(EnumType.STRING)
	private DeliveryManStat State;
	@Enumerated(EnumType.STRING)
	private DeliveryZone DeliveryZone;
	@OneToMany(mappedBy = "Delivery_Man")
	private List<Delivery> Deliveries;
	
	
	
	
	
	@Override
	public String toString() {
		return "Delivery_Man [Delivery_ManId=" + Delivery_ManId + ", Name=" + Name + ", State=" + State
				+ ", DeliveryZone=" + DeliveryZone + ", Deliveries=" + Deliveries + "]";
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
	public DeliveryManStat getState() {
		return State;
	}
	public void setState(DeliveryManStat state) {
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


	public String getNumTel() {
		return NumTel;
	}


	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	
	
	
	
	
}
