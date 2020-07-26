package com.consommi.tounsi.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Admin;
import com.consommi.tounsi.models.Customer;
import com.consommi.tounsi.models.DateInput;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.AdminRepository;
import com.consommi.tounsi.repository.CustomerRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserRepository agent;
	CustomerRepository agentCustomer;
	AdminRepository agentAdmin;
	SupplierRepository agentSupplier;
	List<String> roles = Arrays.asList("Admin", "Customer", "Supplier");
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return agent.findAll();
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	
	@GetMapping("/user/{username}/{password}")
	public ResponseEntity<User> getUserByUserNameAndPassword(@PathVariable(value = "username") String userName,
			@PathVariable(value = "password") String password)
			throws Exception {
		String role= getUserRole(userName, password);
		User user = agent.findByUserNameAndPassword(userName, password)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + 3));
		user.setRole(role);	
		return ResponseEntity.ok().body(user);
		
	}
	
	public String getUserRole(String userName,String password)
			throws Exception {
		String role=agent.getUserRole(userName, password).orElse("Visitor");
			
		
		return role;
		
	}

	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return agent.save(user);
	}
	@PostMapping("/customer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return agent.save(customer);
	}
	

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setUserId(userDetails.getUserId());
		user.setUserName(userDetails.getUserName());
		user.setPassword(userDetails.getPassword());
		final User updatedclient = agent.save(user);
		return ResponseEntity.ok(updatedclient);
	}
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		agent.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping("/verifyuser/{username}")
	public ResponseEntity<Boolean>  VerifUsername(@PathVariable(value = "username") String userName)
	{
System.out.println(agent.verifUsername(userName));
			try {
				if (!agent.verifUsername(userName))
					return ResponseEntity.ok(Boolean.TRUE) ;
				else
					return  ResponseEntity.ok(Boolean.FALSE);
			} catch (Exception e) {
				return  ResponseEntity.ok(Boolean.FALSE);			}	
		
	}
	
	public void copyProperties(User userDetails, User user) {
		if(userDetails.getRole()!=null) {
			user.setRole(userDetails.getRole());
		}
		if (userDetails.getUserName()!=null) {
			user.setUserName(userDetails.getUserName());
		}
		
		if (userDetails.getPassword()!=null) {
			user.setPassword(userDetails.getPassword());
		}
		
			user.setBlocked(userDetails.getBlocked());
		
		
		
	}
	
	@PutMapping("admin/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + userId));        
	    copyProperties(userDetails, user);
		User updateduser = agent.save(user);
		updateduser.setRole("Admin");
		return ResponseEntity.ok(updateduser);
	}
	@GetMapping("/blocked/{id}")
	public ResponseEntity<Boolean> IsBlocked(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		Date date = new Date();  
		if(user.getBlocked()==null)
		return ResponseEntity.ok(Boolean.FALSE);
		else if(user.getBlocked().compareTo(date)<0 ) return  ResponseEntity.ok(Boolean.FALSE);
		else return ResponseEntity.ok(Boolean.TRUE) ;
	}
	
	
	
}
