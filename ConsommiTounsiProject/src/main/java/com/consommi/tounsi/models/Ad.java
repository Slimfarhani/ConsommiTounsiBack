package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AdId;
	private String Title;
	private Date StartDate;
	private Date EndDate;
	private int EstimatedViewNumber;
	private int ActualViewNumber;
	private float Cost;
	private String Type;
	private boolean IsValid;
	@ManyToOne(optional = true)
	private Supplier Supplier;
	
	public Ad() {
		super();
	}

	public long getAdId() {
		return AdId;
	}

	public void setAdId(long adId) {
		AdId = adId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public int getEstimatedViewNumber() {
		return EstimatedViewNumber;
	}

	public void setEstimatedViewNumber(int estimatedViewNumber) {
		EstimatedViewNumber = estimatedViewNumber;
	}

	public int getActualViewNumber() {
		return ActualViewNumber;
	}

	public void setActualViewNumber(int actualViewNumber) {
		ActualViewNumber = actualViewNumber;
	}

	public float getCost() {
		return Cost;
	}

	public void setCost(float cost) {
		Cost = cost;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public boolean getIsValid() {
		return IsValid;
	}

	public void setIsValid(boolean isValid) {
		IsValid = isValid;
	}

	public Supplier getSupplier() {
		return Supplier;
	}

	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	
	
}
