package com.example.flight.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	String email;
	@JsonProperty("password")
	String password;
	@JsonProperty("phoneNumber")
	String phoneNumber;
	@JsonProperty("reservations")
	List<Ticket> reservations;
	@JsonProperty("isAdmin")
	boolean isAdmin;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Ticket> getReservations() {
		return reservations;
	}
	public void setReservations(List<Ticket> reservations) {
		this.reservations = reservations;
	}
	public String getPhone() {
		return phoneNumber;
	}
	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void deleteTicketUsingTicketId(String TicketId) {
		for (Ticket ticket : reservations) {
			if(ticket.ticketId.equals(TicketId)) {
				reservations.remove(ticket);
			}
		}
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", phone=" + phoneNumber + ", isAdmin=" + isAdmin + "]";
	}
	
}
