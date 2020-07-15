package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.consommi.tounsi.enumerations.Category;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ProductId;
	private String ProductName;
	private float Weight;
	private long BarCode;
	@Enumerated(EnumType.STRING)
	private Category Category;
	@ManyToOne
	private Aisle Aisle;
	@OneToMany(mappedBy = "Product")
	private List<Stock> Stock;
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public float getWeight() {
		return Weight;
	}
	public void setWeight(float weight) {
		Weight = weight;
	}
	public long getBarCode() {
		return BarCode;
	}
	public void setBarCode(long barCode) {
		BarCode = barCode;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}
	public Aisle getAisle() {
		return Aisle;
	}
	public void setAisle(Aisle aisle) {
		Aisle = aisle;
	}
	public List<Stock> getStock() {
		return Stock;
	}
	public void setStock(List<Stock> stock) {
		Stock = stock;
	}
}
