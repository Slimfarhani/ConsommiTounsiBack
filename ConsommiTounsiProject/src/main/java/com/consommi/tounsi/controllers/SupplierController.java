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
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.repository.CustomerRepository;
import com.consommi.tounsi.repository.SupplierRepository;
@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {
	
	@Autowired
	SupplierRepository agent;
	
	@GetMapping("/list")
	public List<Supplier> getAllSuppliers() {
		ArrayList<Supplier> list = (ArrayList<Supplier>) agent.findAll();
		for (Supplier supplier : list) {
			supplier.setRole("Supplier");
			
		}
		return list ;
	}
	@GetMapping("/search/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)
			throws ResourceNotFoundException {
		Supplier supplier = agent.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));
		return ResponseEntity.ok().body(supplier);
	}

	@PostMapping("/add")
	public Supplier createSupplier(@Valid @RequestBody Supplier supplier)
    throws ResourceNotFoundException {
		supplier.setRole("Supplier");
		return agent.save(supplier);
	}
	
	public void copyProperties(Supplier supplierDetails, Supplier supplier) {
		if(supplierDetails.getRole()!=null) {
			supplier.setRole(supplierDetails.getRole());
		}
		if (supplierDetails.getUserName()!=null) {
			supplier.setUserName(supplierDetails.getUserName());
		}
		if (supplierDetails.getPhone()!=null) {
			supplier.setPhone(supplierDetails.getPhone());
		}
		if (supplierDetails.getPassword()!=null) {
			supplier.setPassword(supplierDetails.getPassword());
		}
		if (supplierDetails.getName()!=null) {
			supplier.setName(supplierDetails.getName());
		}
		
		if (supplierDetails.getAddress()!=null) {
			supplier.setAddress(supplierDetails.getAddress());
		}
		if (supplierDetails.getMail()!=null) {
			supplier.setMail(supplierDetails.getMail());
		}
		if (supplierDetails.getUrlImage()!=null) {
			supplier.setUrlImage(supplierDetails.getUrlImage());
		}
		if (supplierDetails.getEvents()!=null) {
			supplier.setEvents(supplierDetails.getEvents());
		}
		if (supplierDetails.getStock()!=null) {
			supplier.setStock(supplierDetails.getStock());
		}
		if (supplierDetails.getAds()!=null) {
			supplier.setAds(supplierDetails.getAds());
		}
		
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable(value = "id") Long supplierId,
			@Valid @RequestBody Supplier supplierDetails) throws ResourceNotFoundException {
		Supplier supplier = agent.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + supplierId));        
	    copyProperties(supplierDetails, supplier);
		final Supplier updatedsupplier = agent.save(supplier);
		updatedsupplier.setRole("Supplier");
		return ResponseEntity.ok(updatedsupplier);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") long supplierId)
			throws ResourceNotFoundException {
		Supplier supplier = agent.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));
		agent.delete(supplier);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
