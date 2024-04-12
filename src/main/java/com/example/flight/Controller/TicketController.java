package com.example.flight.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.Entity.Ticket;
import com.example.flight.Service.TicketService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/book")
	public void bookTicket(@RequestBody Ticket ticket) {
		ticketService.bookTicket(ticket);
	}
	
	@GetMapping("/myreservation")
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}
	
	@GetMapping("/myreservation/{id}")
	public Ticket getTicketById(@PathVariable String id) {
		return ticketService.getTicketById(id);
	}
	
	@DeleteMapping("/myreservation/{id}")
	public void deleteTicketById(@PathVariable String id) {
		ticketService.deleteTicket(id);
	}
}