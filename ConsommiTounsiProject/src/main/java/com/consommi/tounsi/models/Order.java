package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long OrderId;
	private boolean IsPaid;
	private int ItemNumber;
	@ManyToOne
	private Customer Customer;
	@OneToMany(mappedBy = "Order_StateId")
	private List<Order_State> Order_States;
	@OneToOne
	@JoinColumn(name = "delivery_id")
	private Delivery Delevery;
	
	

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

	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public List<Order_State> getOrder_States() {
		return Order_States;
	}

	public void setOrder_States(List<Order_State> order_States) {
		Order_States = order_States;
	}

	
	public Delivery getDelevery() {
		return Delevery;
	}

	public void setDelevery(Delivery delevery) {
		Delevery = delevery;
	}
	
	
	
	
	
	
	
	
}