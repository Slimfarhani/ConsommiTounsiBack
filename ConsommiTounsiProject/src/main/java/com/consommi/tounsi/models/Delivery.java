package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long DeliveryId;
	private float Weight;
	private String Address;
	private Date DeliveryDate;
	private String State;
	public Delivery() {
		super();
	}
	private float Rating;
	public long getDeliveryId() {
		return DeliveryId;
	}
	public void setDeliveryId(long deliveryId) {
		DeliveryId = deliveryId;
	}
	public float getWeight() {
		return Weight;
	}
	public void setWeight(float weight) {
		Weight = weight;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public Delivery_Man getDelivery_Man() {
		return Delivery_Man;
	}
	public void setDelivery_Man(Delivery_Man delivery_Man) {
		Delivery_Man = delivery_Man;
	}
	@OneToOne
	private Order Order;
	@ManyToOne
	private Delivery_Man Delivery_Man;
}
