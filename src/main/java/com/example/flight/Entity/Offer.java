package com.example.flight.Entity;

import java.util.UUID;

public class Offer {
	String offerId;
	int cost;
	String origin;
	String destination;
	
	public Offer() {
		this.offerId = UUID.randomUUID().toString();
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String id) {
		this.offerId = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int price) {
		this.cost = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
