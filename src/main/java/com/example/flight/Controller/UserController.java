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
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.Entity.User;
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
		String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        boolean isAdmin = (boolean) requestBody.get("isAdmin");
        
    	WrappedUser wUser = new WrappedUser();
        if(userService.checkUserExists(email)) {
        	if(password.equals(userService.getUserByEmail(email).getPassword())) {
	        	wUser.setEmail(email);
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
	
	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@DeleteMapping("/{email}")
	public void deleteUserByEmail(@PathVariable String email) {
		userService.deleteUser(email);
	}
}
