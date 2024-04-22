package com.example.flight.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.flight.Entity.Ticket;
import com.example.flight.Entity.User;
import com.example.flight.Exceptions.TicketAlreadyExistsException;
import com.example.flight.Exceptions.TicketNotFoundException;

@Service
public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        if (userMap.containsKey(user.getPhone())) {
            throw new TicketAlreadyExistsException("User Exists");
        }
        userMap.put(user.getPhone(), user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserByPhone(String phone) {
        return userMap.get(phone);
    }

    public void deleteUser(String phone) {
        if (!userMap.containsKey(phone)) {
            throw new TicketNotFoundException("User Doesn't Exist");
        }
        userMap.remove(phone);
    }

    public boolean checkUserExists(String phone) {
        return userMap.containsKey(phone);
    }

    // Ticket booking related methods

    public void bookTicket(Ticket ticket, String phoneNumber) {
        User user = userMap.get(phoneNumber);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        if (user.getReservations() == null) {
            user.setReservations(new ArrayList<>());
        }
        user.getReservations().add(ticket);
    }

    public List<Ticket> getAllTickets(String phoneNumber) {
        User user = userMap.get(phoneNumber);
        return user != null ? user.getReservations() : Collections.emptyList();
    }

    public void deleteTicket(String ticketId, String phoneNumber) {
        User user = userMap.get(phoneNumber);
        if (user != null && user.getReservations() != null) {
            user.getReservations().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        } else {
            System.out.println("User or ticket not found");
        }
    }
}
