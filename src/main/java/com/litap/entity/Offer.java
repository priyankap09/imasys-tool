package com.litap.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Offer {

	@Id
	private int offerid;
	private String offerDesc;
	private String status;
	
	public int getOfferid() {
		return offerid;
	}
	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getOfferDesc() {
		return offerDesc;
	}
	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}
	
	
}
