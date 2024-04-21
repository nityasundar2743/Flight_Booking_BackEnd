package com.example.flight.Entity;

import java.util.*;

import javax.persistence.Entity;


@Entity
public class Ticket {
	Offer offer;
	String date;
	List<Passenger> passengers;
	
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
