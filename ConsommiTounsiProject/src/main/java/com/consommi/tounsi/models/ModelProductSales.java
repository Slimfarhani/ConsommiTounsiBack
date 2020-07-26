package com.consommi.tounsi.models;

public class ModelProductSales {

	private long TQuantity;
	private String ProductName;
	private String Description;
	private float Price;

	
	public long getTQuantity() {
		return TQuantity;
	}
	public void setTQuantity(long tQuantity) {
		TQuantity = tQuantity;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
}
