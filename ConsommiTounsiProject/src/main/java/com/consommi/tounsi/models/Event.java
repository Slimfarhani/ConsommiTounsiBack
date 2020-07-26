package com.consommi.tounsi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EventId;
	private String Title;
	private String Location;
	private Date StartDate;
	private Date EndDate;
	private String Description;
	private String UrlImage;
	private int state=0; // 0:en cours de traitement par l'ADMIN; 1: validé ; 2: refusé

	@ManyToOne
	@JoinColumn(name = "supplier_user_id")
	private Supplier Supplier;
	@OneToMany(mappedBy = "Event")
	private List<Participation> Participations;
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public Event(String title, String location, Date startDate, Date endDate, String description, String urlImage,
			int state, com.consommi.tounsi.models.Supplier supplier, List<Participation> participations) {
		super();
		Title = title;
		Location = location;
		StartDate = startDate;
		EndDate = endDate;
		Description = description;
		UrlImage = urlImage;
		this.state = state;
		Supplier = supplier;
		Participations = participations;
	}



	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
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

	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	public Supplier getSupplier() {
		return Supplier;
	}
	public void setSupplier(Supplier supplier) {
		Supplier = supplier;
	}
	@JsonIgnore
	public List<Participation> getParticipations() {
		return Participations;
	}
	public void setParticipations(List<Participation> participations) {
		Participations = participations;
	}
	public String getUrlImage() {
		return UrlImage;
	}
	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
