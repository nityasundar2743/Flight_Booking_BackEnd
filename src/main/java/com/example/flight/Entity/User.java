package com.example.flight.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	String email;
	String password;
	String phone;
	@JsonProperty("isAdmin")
	boolean isAdmin;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", phone=" + phone + ", isAdmin=" + isAdmin + "]";
	}
	
}
