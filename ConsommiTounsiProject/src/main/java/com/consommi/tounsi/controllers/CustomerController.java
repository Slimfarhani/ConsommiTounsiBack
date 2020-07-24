package com.consommi.tounsi.controllers;

import java.util.ArrayList;
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
import com.consommi.tounsi.repository.CustomerRepository;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository agent;
	
	@GetMapping("/list")
	public List<Customer> getAllCustomers() {
		ArrayList<Customer> list = (ArrayList<Customer>) agent.findAll();
		for (Customer customer : list) {
			customer.setRole("Customer");
			
		}
		return list ;
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = agent.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		return ResponseEntity.ok().body(customer);
	}

	@PostMapping("/add")
	public Customer createCustomer(@Valid @RequestBody Customer customer)
    throws ResourceNotFoundException {
		customer.setRole("Customer");
		return agent.save(customer);
	}
	
	public void copyProperties(Customer customerDetails, Customer customer) {
		if(customerDetails.getRole()!=null) {
			customer.setRole(customerDetails.getRole());
		}
		if (customerDetails.getUserName()!=null) {
			customer.setUserName(customerDetails.getUserName());
		}
		if (customerDetails.getPassword()!=null) {
			customer.setPassword(customerDetails.getPassword());
		}
		if (customerDetails.getFirstName()!=null) {
			customer.setFirstName(customerDetails.getFirstName());
		}
		if (customerDetails.getLastName()!=null) {
			customer.setLastName(customerDetails.getLastName());
		}
		if (customerDetails.getAddress()!=null) {
			customer.setAddress(customerDetails.getAddress());
		}
		if (customerDetails.getMail()!=null) {
			customer.setMail(customerDetails.getMail());
		}
		if (customerDetails.getUrlImage()!=null) {
			customer.setUrlImage(customerDetails.getUrlImage());
		}
		if (customerDetails.getOrders()!=null) {
			customer.setOrders(customerDetails.getOrders());
		}
		if (customerDetails.getParticipations()!=null) {
			customer.setParticipations(customerDetails.getParticipations());
		}
		if (customerDetails.getPost_Reacts()!=null) {
			customer.setPost_Reacts(customerDetails.getPost_Reacts());
		}
		
		if (customerDetails.getPhone()!=null) {
			customer.setPhone(customerDetails.getPhone());
		}
		if (customerDetails.getGender()!=null) {
			customer.setGender(customerDetails.getGender());
		}
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = agent.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));        
	    copyProperties(customerDetails, customer);
		final Customer updatedcustomer = agent.save(customer);
		updatedcustomer.setRole("Customer");
		return ResponseEntity.ok(updatedcustomer);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = agent.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		agent.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
