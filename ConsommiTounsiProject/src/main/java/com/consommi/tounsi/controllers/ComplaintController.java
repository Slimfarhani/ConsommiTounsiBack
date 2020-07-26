package com.consommi.tounsi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.enumerations.DeliveryManStat;
import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Complaint;
import com.consommi.tounsi.models.Delivery_Man;
import com.consommi.tounsi.models.Order;

import com.consommi.tounsi.repository.ComplaintRepository;
import com.consommi.tounsi.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/Complaint")
public class ComplaintController {

	@Autowired
	ComplaintRepository complaintRep;
	
	@Autowired
	OrderRepository orderRep;
	
	@GetMapping("/getByIdOrder/{Order}")
	public List<Complaint> getComplaint(@PathVariable(value = "Order") Long Order)
    throws ResourceNotFoundException {
	return complaintRep.findByComplaintyByOrder(Order);
	}
	
	
	@PostMapping("/add/{OrderId}")
	public Complaint createComplaint(@Valid @RequestBody Complaint complaint,@PathVariable(value = "OrderId") Long OrderId)
    throws ResourceNotFoundException {
		System.out.println(">>>> debut ajout createComplaint  ");
		System.out.println(">>>> debut ajout createComplaint order complaint  "+complaint.getOrder());
//		complaint.setOrder(orderRep.findById(OrderId));
//		Optional<Order> ord = 
		complaint.setOrder(orderRep.findOrdersByID(OrderId));
		complaintRep.save(complaint);
		System.out.println(">>>> Fin ajout createComplaint  ");

		 return complaint;
	}
}
