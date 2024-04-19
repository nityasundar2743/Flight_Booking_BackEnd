package com.example.flight.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//wrapping used for login and signUp
public class WrappedUser extends User{
	@JsonProperty("isAuth")
	boolean isAuth;

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	@Override
	public String toString() {
		return "WrappedUser [isAuth=" + isAuth + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", isAdmin=" + isAdmin + "]";
	}
	
}
