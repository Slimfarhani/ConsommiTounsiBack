package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Order_DetailId implements Serializable{

	@Column(name = "product_id")
	private int ProductId;
	@Column(name = "order_id")
	private int OrderId;
	
}
