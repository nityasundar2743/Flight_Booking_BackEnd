package com.example.flight.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException{

	public TicketNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}