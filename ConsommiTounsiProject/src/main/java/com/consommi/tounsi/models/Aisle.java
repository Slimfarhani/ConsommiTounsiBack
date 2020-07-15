package com.consommi.tounsi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
}
