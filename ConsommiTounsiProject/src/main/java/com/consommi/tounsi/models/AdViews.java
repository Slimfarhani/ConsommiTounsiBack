package com.consommi.tounsi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdViews {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AdViewId;
	private long AdId;
	private long UserId;
	public long getAdViewId() {
		return AdViewId;
	}
	public void setAdViewId(long adViewId) {
		AdViewId = adViewId;
	}
	public long getAdId() {
		return AdId;
	}
	public void setAdId(long adId) {
		AdId = adId;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}

}
