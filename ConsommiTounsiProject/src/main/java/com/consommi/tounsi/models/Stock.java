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
	public StockId getStockId() {
		return StockId;
	}
	public void setStockId(StockId stockId) {
		StockId = stockId;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public float getQuantity() {
		return Quantity;
	}
	public void setQuantity(float quantity) {
		Quantity = quantity;
	}
	public String getMesure() {
		return Mesure;
	}
	public void setMesure(String mesure) {
		Mesure = mesure;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public Stock() {
		super();
	}
}
