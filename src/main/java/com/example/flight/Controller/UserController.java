package com.example.flight.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.Entity.Ticket;
import com.example.flight.Entity.User;
import com.example.flight.Entity.WrappedTicket;
import com.example.flight.Entity.WrappedUser;
import com.example.flight.Exceptions.InvalidLoginCredentialException;
import com.example.flight.Exceptions.UserNotFoundException;
import com.example.flight.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public WrappedUser signUp(@RequestBody User user) {
		userService.addUser(user);
		WrappedUser wUser = new WrappedUser();
		wUser.setAuth(true);
		wUser.setAdmin(user.isAdmin());
		wUser.setEmail(user.getEmail());
		wUser.setPassword(null);
		wUser.setPhone(user.getPhone());
		System.out.println(wUser.toString());
		return wUser;
	}
	
	@PostMapping("/login")
	public WrappedUser logIn(@RequestBody Map<String, Object> requestBody) {
		String phoneNumber = (String) requestBody.get("phoneNumber");
        String password = (String) requestBody.get("password");
        boolean isAdmin = (boolean) requestBody.get("isAdmin");
        
    	WrappedUser wUser = new WrappedUser();
        if(userService.checkUserExists(phoneNumber)) {
        	if(password.equals(userService.getUserByPhone(phoneNumber).getPassword())) {
	        	//wUser.setEmail(email);
	        	wUser.setPassword(null);
	        	wUser.setAdmin(isAdmin);
	        	wUser.setAuth(true);
	        	return wUser;
        	}
            else {
            	throw new InvalidLoginCredentialException("Invalid Login Credentials!");
            }
        }
        else {
        	throw new UserNotFoundException("User Not Found!");
        }

	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{phoneNumber}")
	public User getUserByEmail(@PathVariable String phoneNumber) {
		return userService.getUserByPhone(phoneNumber);
	}
	
	@DeleteMapping("/{phoneNumber}")
	public void deleteUserByEmail(@PathVariable String phoneNumber) {
		userService.deleteUser(phoneNumber);
	}
	
	// related to ticketBooking
	
	@PostMapping("/book")
	public void bookTicket(@RequestBody WrappedTicket wTicket) {
//		Ticket ticket = (Ticket)requestBody.get("ticket");
//		String phoneNumber = (String) requestBody.get("phoneNumber");
		wTicket.toString();
		Ticket ticket = new Ticket();
		ticket.setDate(wTicket.getDate());
		ticket.setOffer(wTicket.getOffer());
		ticket.setPassengers(wTicket.getPassengers());
		ticket.setTicketId(wTicket.getTicketId());
		userService.bookTicket(ticket, wTicket.getPhoneNumber());
	}
	
	@GetMapping("/myreservation")
	public List<Ticket> getAllTickets(@RequestParam("phoneNumber") String phoneNumber) {
		return userService.getAllTickets(phoneNumber);
	}
	
//	@GetMapping("/myreservation/{ticketId}")
//	public Ticket getTicketById(@PathVariable String ticketId) {
//		return userService.getTicketById(ticketId);
//	}
	
	@DeleteMapping("/myreservation/{ticketId}")
	public void deleteTicketById(@RequestBody Map<String, Object> requestBody) {
		String ticketId = (String)requestBody.get("ticketId");
		String phoneNumber = (String) requestBody.get("phoneNumber");
		userService.deleteTicket(ticketId, phoneNumber);
	}
}
