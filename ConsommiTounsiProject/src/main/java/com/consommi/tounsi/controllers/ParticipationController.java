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
import com.consommi.tounsi.models.Customer;
import com.consommi.tounsi.models.Event;
import com.consommi.tounsi.models.Participation;
import com.consommi.tounsi.models.ParticipationId;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Product;
import com.consommi.tounsi.models.Stock;
import com.consommi.tounsi.models.StockId;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.CustomerRepository;
import com.consommi.tounsi.repository.EventRepository;
import com.consommi.tounsi.repository.ParticipationRepository;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.ProductRepository;
import com.consommi.tounsi.repository.StockRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class ParticipationController {

	@Autowired
	ParticipationRepository agent;
	@Autowired
	CustomerRepository agentCustomer;
	@Autowired
	EventRepository agentEvent;
	@GetMapping("/participation")
	public List<Participation> getAllParticipations() {
		return agent.findAll();
	}
	@GetMapping("/participation/{id}")
	public ResponseEntity<Participation> getParticipationById(@PathVariable(value = "id") Long participationId)
			throws ResourceNotFoundException {
		Participation participation = agent.findById(participationId)
				.orElseThrow(() -> new ResourceNotFoundException("Participation not found for this id :: " + participationId));
		return ResponseEntity.ok().body(participation);
	}

	@PostMapping("/participation/{customerid}/{eventid}")
	public Participation createParticipation(@Valid @RequestBody Participation participation,@PathVariable(value = "customerid")
	Long customerId,@PathVariable(value = "eventid") Long eventId) throws ResourceNotFoundException {
		Customer customer = agentCustomer.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		Event event = agentEvent.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		participation.setParticipationId(new ParticipationId(customerId,eventId));
		participation.setEvent(event);
		participation.setCustomer(customer);
		return agent.save(participation);
	}

	@PutMapping("/participation/{id}")
	public ResponseEntity<Participation> updateParticipation(@PathVariable(value = "id") Long participationId,
			@Valid @RequestBody Participation participationDetails) throws ResourceNotFoundException {
		Participation participation = agent.findById(participationId)
				.orElseThrow(() -> new ResourceNotFoundException("participation not found for this id :: " + participationId));
		final Participation updatedparticipation = agent.save(participation);
		return ResponseEntity.ok(updatedparticipation);
	}
	@DeleteMapping("/participation/{id}")
	public Map<String, Boolean> deleteParticipation(@PathVariable(value = "id") Long participationId)
			throws ResourceNotFoundException {
		Participation participation = agent.findById(participationId)
				.orElseThrow(() -> new ResourceNotFoundException("Participation not found for this id :: " + participationId));
		agent.delete(participation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
