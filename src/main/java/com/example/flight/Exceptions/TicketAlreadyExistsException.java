package com.example.flight.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TicketAlreadyExistsException extends RuntimeException{

	public TicketAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}