package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long OrderId;
	private boolean IsPaid;
	private int ItemNumber;
	private float Total;
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public Delivery getDelivery() {
		return Delivery;
	}
	public void setDelivery(Delivery delivery) {
		Delivery = delivery;
	}
	private String DeliveryMethod;
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Delivery Delivery;
	public Order() {
		super();
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public boolean isIsPaid() {
		return IsPaid;
	}
	public void setIsPaid(boolean isPaid) {
		IsPaid = isPaid;
	}
	public int getItemNumber() {
		return ItemNumber;
	}
	public void setItemNumber(int itemNumber) {
		ItemNumber = itemNumber;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	public List<Order_State> getStates() {
		return States;
	}
	public void setStates(List<Order_State> states) {
		this.States = states;
	}
	@ManyToOne
	private Customer Customer;
	@OneToMany(mappedBy = "Order",cascade = CascadeType.ALL)
	private List<Order_State> States;
	@OneToMany(mappedBy = "Order",cascade = CascadeType.ALL)
	private List<Order_Detail> Details;
	public List<Order_Detail> getDetails() {
		return Details;
	}
	public void setDetails(List<Order_Detail> details) {
		Details = details;
	}
	
}