package com.consommi.tounsi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EventId;
	private String Title;
	private String Location;
	private Date StartDate;
	private String EndDate;
	@ManyToOne
	private Supplier Supplier;
	@OneToMany(mappedBy = "Event")
	private List<Participation> Participations;
	public long getEventId() {
		return EventId;
	}
	public void setEventId(long eventId) {
		EventId = eventId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	public List<Participation> getParticipations() {
		return Participations;
	}
	public void setParticipations(List<Participation> participations) {
		Participations = participations;
	}
	
}
