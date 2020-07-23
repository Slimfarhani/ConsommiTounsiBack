package com.consommi.tounsi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.enumerations.DeliveryZone;
import com.consommi.tounsi.enumerations.StatutCmd;
import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Delivery;
import com.consommi.tounsi.models.Delivery_Man;
import com.consommi.tounsi.models.Order;
import com.consommi.tounsi.models.Product;
import com.consommi.tounsi.repository.DeliveryManRepository;
import com.consommi.tounsi.repository.DeliveryRepository;
import com.consommi.tounsi.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/")
public class DeliveryController {

	@Autowired
	DeliveryRepository deliveryRep ;
	
	@Autowired
	OrderRepository orderRep ;

	@Autowired
	DeliveryManRepository deliveryManRep ;
	
	@PostMapping("/Delivery/{idOrder}/{address}")
	public Delivery CreateDelivery
	(
	 @PathVariable(value = "idOrder")Long idOrder,
	 @PathVariable(value = "address")String address) throws ResourceNotFoundException {
		System.out.println("Debut CreateDelivery ");
		if(idOrder!=null ) {
			Order ord=null;
		
			ord= orderRep.findById(idOrder).get();
		
		System.out.println("Order ---> "+ord.toString());
		
		Delivery delivery ;
		if(ord.getDelevery()!=null) {
		System.out.println("delivery ---> "+ord.getDelevery().toString());
		delivery= ord.getDelevery();
		}
		else {
			delivery = new Delivery();
		}
		System.out.println("value of enum "+DeliveryZone.valueOf(address.trim()));
		delivery.setState(StatutCmd.delivered);
		delivery.setOrder(ord);
		delivery.setDeliveryDate(new Date());
		
		
		delivery.setAddress(DeliveryZone.valueOf(address.trim()));
		if(!DeliveryZone.valueOf(address.trim()).equals(DeliveryZone.shop))
		{List<Delivery_Man> lstDvMan =deliveryManRep.findAll();
		for(Delivery_Man devMan : lstDvMan) {
			if (devMan.getDeliveryZone().toString().equals(address)) {
				delivery.setDelivery_Man(devMan);
				break;
			}
		}
		}
		deliveryRep.save(delivery);
		
		ord.setDelevery(delivery);
		orderRep.save(ord);

		return 	delivery	;
		
			}
		return null;
		}
	
	
	
	@GetMapping("/Delivery/Consumer/{idUser}")
	public ResponseEntity<List<Delivery>> getDeliveryConsumer(@PathVariable(value = "idUser") Long idUser)
			throws ResourceNotFoundException {
		List<Delivery> deliverys = deliveryRep.findByDeliveryByConsumer(idUser)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id Costommer :: " + idUser));
		return ResponseEntity.ok().body(deliverys);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
