package com.example.flight.Entity;


public class Offer {
	int offerId;
	int cost;
	String origin;
	String destination;
	
//	public Offer() {
//		this.offerId = UUID.randomUUID().toString();
//	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int id) {
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
