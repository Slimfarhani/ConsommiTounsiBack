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
}
