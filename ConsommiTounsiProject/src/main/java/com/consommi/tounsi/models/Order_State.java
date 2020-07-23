package com.consommi.tounsi.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import java.util.Date;

@Entity
public class Order_State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Order_StateId;
	private String Type;
	private Date Date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderId")
	private Order Order;
	
	
	
	
	
	@Override
	public String toString() {
		return "Order_State [Order_StateId=" + Order_StateId + ", Type=" + Type + ", Date=" + Date + ", Order=" + Order
				+ "]";
	}

	public Order getOrder() {
		return Order;
	}

	public void setOrder(Order order) {
		Order = order;
	}


	
	public long getOrder_StateId() {
		return Order_StateId;
	}
	public void setOrder_StateId(long order_StateId) {
		Order_StateId = order_StateId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	
}
