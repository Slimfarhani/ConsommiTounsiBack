package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int EventId;
	private String Title;
	private String Location;
	private Date StartDate;
	private String EndDate;
	@ManyToOne
	private Supplier Supplier;
}
