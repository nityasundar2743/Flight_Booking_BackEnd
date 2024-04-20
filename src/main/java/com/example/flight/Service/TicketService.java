package com.example.flight.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.flight.Entity.Ticket;
import com.example.flight.Exceptions.TicketAlreadyExistsException;
import com.example.flight.Exceptions.TicketNotFoundException;

@Service
public class TicketService {
	 
	List<Ticket> ticketList= new ArrayList<Ticket>();
	Map<String, Ticket> ticketMap = new HashMap<String, Ticket>();
	
	public void bookTicket(Ticket ticket) {
		if(ticketMap.containsKey(ticket.getOffer().getOfferId())) {
			throw new TicketAlreadyExistsException("Ticket Already Exists");
		}
		else {
			ticketList.add(ticket);
			ticketMap.put(ticket.getOffer().getOfferId(), ticket);
		}
	}
	
	public List<Ticket> getAllTickets() {
		return ticketList;
	}
	
	/** This method retrieves a ticket based on its unique id from ticketmap. **/ 
	public Ticket getTicketById(String offerId) {
		if(ObjectUtils.isEmpty(ticketMap.get(offerId))) {
			System.out.println("Ticket not found");
		}
		return ticketMap.get(offerId);
	}
	
	public void deleteTicket(String offerId) {
		if(ObjectUtils.isEmpty(ticketMap.get(offerId))) {
			throw new TicketNotFoundException("Ticket Doesn't Exists");
		}
		else {
			Ticket ticket = getTicketById(offerId);
			ticketList.remove(ticket);
			ticketMap.remove(offerId);
		}
	}
	public int getPriceById(String offerId) {
		if(ObjectUtils.isEmpty(ticketMap.get(offerId))) {
			throw new TicketNotFoundException("Ticket Doesn't Exists");
		}
		else {
			Ticket ticket = getTicketById(offerId);
			return ticket.getOffer().getCost();
		}
	}
}