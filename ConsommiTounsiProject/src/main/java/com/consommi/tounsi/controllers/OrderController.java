package com.consommi.tounsi.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
import com.consommi.tounsi.models.Order_State;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.AdminRepository;
import com.consommi.tounsi.repository.CustomerRepository;
import com.consommi.tounsi.repository.OrderRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	OrderRepository agent;
	CustomerRepository agentCustomer;
	AdminRepository agentAdmin;
	SupplierRepository agentSupplier;
	List<String> roles = Arrays.asList("Admin", "Customer", "Supplier");
	@GetMapping("/order")
	public List<Order> getAllOrders() {
		return agent.findAll();
	}
	@GetMapping("/orderbycustomer/{idcustomer}")
	public Optional<List<Order>> getOrdersByCustomer(@PathVariable(value = "idcustomer") Long customerId) {
		return agent.findOrdersByCustomer(customerId);
	}
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long OrderId)
			throws ResourceNotFoundException {
		Order Order = agent.findById(OrderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + OrderId));
		return ResponseEntity.ok().body(Order);
	}
	
	
	

	@PostMapping("/order")
	public Order createOrder(@Valid @RequestBody Order Order) {
		List<Order_Detail> details=Order.getDetails();
		float total=0;
		int itemNumber=0;
		for (Order_Detail order_Detail : details) {
			total+=order_Detail.getPrice()*order_Detail.getQuantity();
			itemNumber+=order_Detail.getQuantity();
			order_Detail.setOrder(Order);
		}
		Order.setDetails(details);
		Order.setTotal(total);
		Order.setItemNumber(itemNumber);
		Order_State state=new Order_State();
		state.setOrder(Order);
		state.setDate(new Date(System.currentTimeMillis()));
		state.setType("Confirmed");
		List<Order_State> states=new ArrayList<Order_State>();
		states.add(state);
		Order.setStates(states);
		final Order OrderCreated=agent.save(Order);
		return OrderCreated;
	}
	

	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long OrderId,
			@Valid @RequestBody Order OrderDetails) throws ResourceNotFoundException {
		Order Order = agent.findById(OrderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + OrderId));

		Order.setOrderId(OrderDetails.getOrderId());
		final Order updatedOrder = agent.save(Order);
		return ResponseEntity.ok(updatedOrder);
	}
	@DeleteMapping("/order/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long OrderId)
			throws ResourceNotFoundException {
		Order Order = agent.findById(OrderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + OrderId));
		agent.delete(Order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
