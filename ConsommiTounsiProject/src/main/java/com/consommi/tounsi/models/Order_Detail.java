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
}
