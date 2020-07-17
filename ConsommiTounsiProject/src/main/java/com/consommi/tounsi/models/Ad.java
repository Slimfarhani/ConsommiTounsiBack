package com.consommi.tounsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
}
