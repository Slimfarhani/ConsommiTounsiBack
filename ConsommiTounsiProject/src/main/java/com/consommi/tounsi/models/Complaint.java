package com.consommi.tounsi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ComplaintId;
	private String Topic;
	private String Description;
	private int State;

	@ManyToOne
	private Order Order;
	
	public long getComplaintId() {
		return ComplaintId;
	}
	public void setComplaintId(long complaintId) {
		ComplaintId = complaintId;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getState() {
		return State;
	}
	public void setState(int state) {
		State = state;
	}
	

	
	@JsonIgnore
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		this.Order = order;
	}
	
	
	
	
	
}
