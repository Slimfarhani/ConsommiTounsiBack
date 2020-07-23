package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;

@Embeddable
public class Order_DetailId implements Serializable{

	@Column(name = "product_id")
	private long ProductId;
	@Column(name = "order_id")
	private long OrderId;
	@Column(name = "supplier_id")
	private long SupplierId;
	
	
	
	
	@Override
	public String toString() {
		return "Order_DetailId [ProductId=" + ProductId + ", OrderId=" + OrderId + ", SupplierId=" + SupplierId + "]";
	}
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public long getOrderId() {
		return OrderId;
	}
	public void setOrderId(long orderId) {
		OrderId = orderId;
	}
	public long getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(long supplierId) {
		SupplierId = supplierId;
	}
	
	

}
