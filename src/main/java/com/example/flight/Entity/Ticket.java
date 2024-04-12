package com.example.flight.Entity;

import java.util.List;

import javax.persistence.Entity;


@Entity
public class Ticket {
	Offer offer;
	String phone;
	List<String> passengers;
	
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public List<String> getNames() {
		return passengers;
	}
	public void setNames(List<String> names) {
		passengers = names;
	}
}
