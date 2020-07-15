package com.consommi.tounsi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StockId implements Serializable{

	@Column(name = "supplier_id")
	private long SupplierId;
	@Column(name = "product_id")
	private long ProductId;
	public long getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(long supplierId) {
		SupplierId = supplierId;
	}
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public StockId(long supplierId, long productId) {
		super();
		SupplierId = supplierId;
		ProductId = productId;
	}
	public StockId() {
		super();
	}
	
}
