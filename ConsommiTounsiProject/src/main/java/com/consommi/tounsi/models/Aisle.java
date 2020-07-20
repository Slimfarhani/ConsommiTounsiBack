package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aisle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AisleId;
	private String Name;
	private int Number;
	private String Type;
	private String Description;
	@OneToMany(mappedBy = "Aisle")
	private List<Product> Products;
	public long getAisleId() {
		return AisleId;
	}
	public void setAisleId(long aisleId) {
		AisleId = aisleId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@JsonIgnore
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> products) {
		Products = products;
	}
}
