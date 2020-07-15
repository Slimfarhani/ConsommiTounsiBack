package com.consommi.tounsi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order_State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Order_StateId;
	private String Type;
	private Date Date;
}
