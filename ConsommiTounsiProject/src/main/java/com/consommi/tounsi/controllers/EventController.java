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
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.repository.EventRepository;
import com.consommi.tounsi.repository.ParticipationRepository;
import com.consommi.tounsi.repository.SupplierRepository;


@RestController
@RequestMapping("/api/v1/events")
public class EventController {

	@Autowired
	EventRepository agent;
	@Autowired
	SupplierRepository agentSupplier;
	@Autowired
	ParticipationRepository agentParticipation;
	
	@GetMapping("/list")
	public List<Event> getAllEvents() {
		return agent.findAll();
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		return ResponseEntity.ok().body(event);
	}
	
	@GetMapping("/ByLocation/{location}")
	public List<Event> getEventByLocation(@PathVariable(value = "location") String location)
	{	
		return agent.findByLocation(location);
				
	}
	
	@GetMapping("/ByState/{state}")
	public List<Event> getEventByLocation(@PathVariable(value = "state") int state)
	{	
		return agent.findByState(state);
				
	}
	
	@GetMapping("/BySupplier/{SupplierID}")
	public List<Event> getEventBySupplier(@PathVariable(value = "SupplierID") Long SupplierID)
	{	
		return agent.findBySupplier(SupplierID);
				
	}
	@GetMapping("/Donations/{EventID}")
	public float getTotalDonations(@PathVariable(value = "EventID") Long EventID)
	{	
		return agent.TotalDonations(EventID);
				
	}

	/*@PostMapping("/event/{supplierid}")
	public Event createEvent(@Valid @RequestBody Event event,@PathVariable(value = "supplierid")
	Long supplierId) throws ResourceNotFoundException {
		Supplier supplier = agentSupplier.findById(supplierId).orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + supplierId));
		event.setSupplier(supplier);
		return agent.save(event);
	}*/
	
	//************************* SUPPLIER *************************************************
	@PostMapping("/add")
	public Event createEvent(@Valid @RequestBody Event event)
    throws ResourceNotFoundException {
		return agent.save(event);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
			@Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		event.setDescription(eventDetails.getDescription());
		event.setEndDate(eventDetails.getEndDate());
		event.setStartDate(eventDetails.getStartDate());
		event.setLocation(eventDetails.getLocation());
		event.setTitle(eventDetails.getTitle());
		event.setUrlImage(eventDetails.getUrlImage());
		final Event updatedevent = agent.save(event);
		return ResponseEntity.ok(updatedevent);
	}
	

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		agent.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
   // ************************* Client  *****************************
	@PostMapping("/subscribe")
	public Participation SubscribeEvent(@Valid @RequestBody Participation participation)
    throws ResourceNotFoundException {
		return agentParticipation.save(participation);
	}
	
	// *********************** ADMIN *****************************************************
	
	@PutMapping("/accept/{id}")
	public ResponseEntity<Event> AcceptEvent(@PathVariable(value = "id") Long eventId,
			@Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		event.setState(1);
		final Event updatedevent = agent.save(event);
		return ResponseEntity.ok(updatedevent);
	}
	
	@PutMapping("/refuse/{id}")
	public ResponseEntity<Event> RefuseEvent(@PathVariable(value = "id") Long eventId,
			@Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = agent.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		event.setState(2);
		final Event updatedevent = agent.save(event);
		return ResponseEntity.ok(updatedevent);
	}
	
}
