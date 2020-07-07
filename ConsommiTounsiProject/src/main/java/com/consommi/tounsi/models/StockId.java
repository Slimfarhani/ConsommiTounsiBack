package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StockId implements Serializable{

	@Column(name = "supplier_id")
	private int SupplierId;
	@Column(name = "product_id")
	private int ProductId;
	
}
