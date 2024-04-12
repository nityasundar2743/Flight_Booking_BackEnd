package com.example.flight.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.flight.Entity.User;
import com.example.flight.Exceptions.TicketAlreadyExistsException;
import com.example.flight.Exceptions.TicketNotFoundException;

@Service
public class UserService {
	List<User> userList= new ArrayList<User>();
	Map<String, User> userMap = new HashMap<String, User>();
	
	public void addUser(User user) {
		if(userMap.containsKey(user.getEmail())) {
			throw new TicketAlreadyExistsException("User Exists");
		}
		else {
			userList.add(user);
			userMap.put(user.getEmail(), user);
		}
	}
	
	public List<User> getAllUsers() {
		return userList;
	}
	
	/** This method retrieves a ticket based on its unique id from ticketmap. **/ 
	public User getUserByEmail(String email) {
		if(ObjectUtils.isEmpty(userMap.get(email))) {
			System.out.println("User not found");
		}
		return userMap.get(email);
	}
	
	public void deleteUser(String email) {
		if(ObjectUtils.isEmpty(userMap.get(email))) {
			throw new TicketNotFoundException("User Doesn't Exists");
		}
		else {
			User user = getUserByEmail(email);
			userList.remove(user);
			userMap.remove(email);
		}
	}
	
	public boolean checkUserExists(String email) {
		if(ObjectUtils.isEmpty(userMap.get(email))) {
			return false;
		}
		return true;
	}
}
