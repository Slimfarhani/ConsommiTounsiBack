package com.consommi.tounsi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Stock {

	@EmbeddedId
	private StockId StockId;
	@ManyToOne
	@MapsId("product_id")
	@JoinColumn(name = "product_id")
	private Product Product;
	@ManyToOne
	@MapsId("supplier_id")
	@JoinColumn(name = "supplier_id")
	private Supplier Supplier;
	private float Quantity;
	private String Mesure;
	private float Price;
}
