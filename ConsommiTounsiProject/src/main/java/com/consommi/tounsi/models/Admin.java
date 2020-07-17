package com.consommi.tounsi.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {

	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Admin(String name) {
		super();
		Name = name;
	}

	public Admin() {
		super();
	}
}
