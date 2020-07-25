package com.consommi.tounsi.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.consommi.tounsi.models.Order;
import com.consommi.tounsi.models.Order_Detail;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.AdminRepository;
import com.consommi.tounsi.repository.CustomerRepository;
import com.consommi.tounsi.repository.OrderRepository;
import com.consommi.tounsi.repository.Order_DetailRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class Order_DetailController {

	@Autowired
	Order_DetailRepository agent;
	CustomerRepository agentCustomer;
	AdminRepository agentAdmin;
	SupplierRepository agentSupplier;
	List<String> roles = Arrays.asList("Admin", "Customer", "Supplier");
	@GetMapping("/order_detail")
	public List<Order_Detail> getAllOrder_Details() {
		return agent.findAll();
	}
	@GetMapping("/order_detail/{id}")
	public ResponseEntity<Order_Detail> getOrder_DetailById(@PathVariable(value = "id") Long Order_DetailId)
			throws ResourceNotFoundException {
		Order_Detail Order_Detail = agent.findById(Order_DetailId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Detail not found for this id :: " + Order_DetailId));
		return ResponseEntity.ok().body(Order_Detail);
	}
	
	
	

	@PostMapping("/order_detail")
	public Order_Detail createOrder_Detail(@Valid @RequestBody Order_Detail Order_Detail) {
		final Order_Detail Order_DetailCreated=agent.save(Order_Detail);
		return Order_DetailCreated;
	}
	

	@PutMapping("/order_detail/{id}")
	public ResponseEntity<Order_Detail> updateOrder_Detail(@PathVariable(value = "id") Long Order_DetailId,
			@Valid @RequestBody Order_Detail Order_DetailDetails) throws ResourceNotFoundException {
		Order_Detail Order_Detail = agent.findById(Order_DetailId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Detail not found for this id :: " + Order_DetailId));

		Order_Detail.setOrder_DetailId(Order_DetailDetails.getOrder_DetailId());
		final Order_Detail updatedOrder_Detail = agent.save(Order_Detail);
		return ResponseEntity.ok(updatedOrder_Detail);
	}
	@DeleteMapping("/order_detail/{id}")
	public Map<String, Boolean> deleteOrder_Detail(@PathVariable(value = "id") Long Order_DetailId)
			throws ResourceNotFoundException {
		Order_Detail Order_Detail = agent.findById(Order_DetailId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Detail not found for this id :: " + Order_DetailId));
		agent.delete(Order_Detail);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
