package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Order_Detail {

	@EmbeddedId
	private Order_DetailId Order_DetailId;
	
	@ManyToOne
	@MapsId("product_id")
	@JoinColumn(name = "product_id")
	private Product Product;
	
	@ManyToOne
	@MapsId("order_id")
	@JoinColumn(name = "order_id")
	private Order Order;
	
	@ManyToOne
	@MapsId("supplier_id")
	@JoinColumn(name = "supplier_id")
	private Supplier Supplier;
	
	
	
	@Override
	public String toString() {
		return "Order_Detail [Order_DetailId=" + Order_DetailId + ", Product=" + Product + ", Order=" + Order
				+ ", Supplier=" + Supplier + "]";
	}
	
	public Order_DetailId getOrder_DetailId() {
		return Order_DetailId;
	}
	public void setOrder_DetailId(Order_DetailId order_DetailId) {
		Order_DetailId = order_DetailId;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
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
	
	
	
	
}
