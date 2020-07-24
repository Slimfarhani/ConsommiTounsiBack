package com.consommi.tounsi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommi.tounsi.models.Event;
import com.consommi.tounsi.repository.EventRepository;


@Service
@Transactional
public class EventServices {

	
	@Autowired
	EventRepository agent;
	
	public List<Event> getAllEvents(){
		return agent.findAll();
	}
	
	public Event addOrUpdateEvent(Event event) {
		agent.save(event);
		return event;
	}
}
