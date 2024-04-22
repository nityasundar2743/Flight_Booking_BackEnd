package com.example.flight.Entity;

import java.util.*;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

@Entity
public class Ticket {
	@JsonProperty("ticketId")
	String ticketId;
	@JsonProperty("offer")
	Offer offer;
	@JsonProperty("date")
	String date;
	@JsonProperty("passengers")
	List<Passenger> passengers;
	
	public Ticket() {
		this.ticketId = UUID.randomUUID().toString();
		this.date = "1-1-2024";
	}
	
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
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", offer=" + offer + ", date=" + date + ", passengers=" + passengers
				+ "]";
	}
	
}
