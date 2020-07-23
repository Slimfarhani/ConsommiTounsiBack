package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.consommi.tounsi.enumerations.DeliveryZone;
import com.consommi.tounsi.enumerations.StatutCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long DeliveryId;
	
	private String DeliveryMethod;
	private float Weight;
	@Enumerated(EnumType.STRING)
	private DeliveryZone Address;
	private Date DeliveryDate;
	@Enumerated(EnumType.STRING)
	private StatutCmd State;
	private float Rating;
	

	@ManyToOne
	private Delivery_Man Delivery_Man;
	@OneToOne
	@JoinColumn(name = "order_Id")
	private Order Order;
	
	
	public long getDeliveryId() {
		return DeliveryId;
	}
	public void setDeliveryId(long deliveryId) {
		DeliveryId = deliveryId;
	}
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public float getWeight() {
		return Weight;
	}
	public void setWeight(float weight) {
		Weight = weight;
	}

	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public StatutCmd getState() {
		return State;
	}
	public void setState(StatutCmd state) {
		State = state;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	@JsonIgnore
	public Delivery_Man getDelivery_Man() {
		return Delivery_Man;
	}
	public void setDelivery_Man(Delivery_Man delivery_Man) {
		Delivery_Man = delivery_Man;
	}
	@JsonIgnore
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	
	
	public DeliveryZone getAddress() {
		return Address;
	}
	public void setAddress(DeliveryZone address) {
		Address = address;
	}
	
	
	
	
	
}
