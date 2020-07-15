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
import com.consommi.tounsi.models.Event;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.EventRepository;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class EventController {

	@Autowired
	EventRepository agent;
	@Autowired
	SupplierRepository agentSupplier;
	@GetMapping("/event")
	public List<Event> getAllEvents() {
		return agent.findAll();
	}
	@GetMapping("/event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		return ResponseEntity.ok().body(event);
	}

	@PostMapping("/event/{supplierid}")
	public Event createEvent(@Valid @RequestBody Event event,@PathVariable(value = "supplierid")
	Long supplierId) throws ResourceNotFoundException {
		Supplier supplier = agentSupplier.findById(supplierId).orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + supplierId));
		event.setSupplier(supplier);
		return agent.save(event);
	}

	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
			@Valid @RequestBody Post eventDetails) throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		
		final Event updatedevent = agent.save(event);
		return ResponseEntity.ok(updatedevent);
	}
	@DeleteMapping("/event/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		agent.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
