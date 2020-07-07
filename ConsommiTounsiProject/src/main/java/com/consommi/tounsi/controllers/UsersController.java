package com.consommi.tounsi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.consommi.tounsi.models.Users;
import com.consommi.tounsi.repository.UsersRepository;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

	@Autowired
	UsersRepository agent;
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return agent.findAll();
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		Users user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public Users createEmployee(@Valid @RequestBody Users user) {
		return agent.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateEmployee(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody Users userDetails) throws ResourceNotFoundException {
		Users user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setId(userDetails.getId());
		user.setLogin(userDetails.getLogin());
		user.setPassword(userDetails.getPassword());
		final Users updatedclient = agent.save(user);
		return ResponseEntity.ok(updatedclient);
	}
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		Users user = agent.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		agent.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
