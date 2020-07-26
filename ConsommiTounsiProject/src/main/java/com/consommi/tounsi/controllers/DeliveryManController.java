package com.consommi.tounsi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.enumerations.DeliveryManStat;
import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Delivery_Man;
import com.consommi.tounsi.repository.DeliveryManRepository;

@RestController
@RequestMapping("/api/v1/DeliveryMan")
public class DeliveryManController {

	
	@Autowired
	DeliveryManRepository delManRep;
	
	@PostMapping("/add")
	public Delivery_Man createDeliveryMan(@Valid @RequestBody Delivery_Man deliveryMan)
    throws ResourceNotFoundException {
		System.out.println(">>>> debut ajout Delivery MAn ");
		deliveryMan.setState(DeliveryManStat.available);
		 delManRep.save(deliveryMan);
		System.out.println(">>>> Fin ajout Delivery MAn ");

		 return deliveryMan;
	}
	
	@PutMapping("/put")
	public Delivery_Man updateDeliveryMan(@Valid @RequestBody Delivery_Man deliveryMan)
    throws ResourceNotFoundException {
		return delManRep.save(deliveryMan);
	}
	
	@GetMapping("/getAll")
	public List<Delivery_Man> getDeliveryMan()
    throws ResourceNotFoundException {
		return delManRep.findAll();
	}
	
	@GetMapping("/getById/{Delivery_ManId}")
	public Optional<Delivery_Man> getDeliveryMan(@PathVariable(value = "Delivery_ManId") Long Delivery_ManId)
    throws ResourceNotFoundException {
		return delManRep.findById(Delivery_ManId);
	}
	
	@DeleteMapping("/delete")
	public List<Delivery_Man> deleteDeliveryMan(@Valid @RequestBody Delivery_Man deliveryMan)
    throws ResourceNotFoundException {
	  delManRep.delete(deliveryMan);
      return delManRep.findAll(); 
	}
}
