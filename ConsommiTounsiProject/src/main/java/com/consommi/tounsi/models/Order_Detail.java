package com.consommi.tounsi.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order_Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Order_DetailId;
	@ManyToOne
	private Product Product;
	@ManyToOne
	
	private Order Order;
	@ManyToOne
	private Supplier Supplier;
	private int Quantity;
	private float Total;
	public long getOrder_DetailId() {
		return Order_DetailId;
	}
	public void setOrder_DetailId(long order_DetailId) {
		Order_DetailId = order_DetailId;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	@JsonIgnore
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
}
