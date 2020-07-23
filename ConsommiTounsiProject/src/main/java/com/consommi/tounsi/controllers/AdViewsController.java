package com.consommi.tounsi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.AdViews;
import com.consommi.tounsi.repository.AdRepository;
import com.consommi.tounsi.repository.AdViewsRepository;
import com.consommi.tounsi.repository.SupplierRepository;

@RestController
@RequestMapping("/api/v1")
public class AdViewsController {

	@Autowired
	AdViewsRepository agent;
	@Autowired
	AdRepository agentAd;
	@Autowired
	SupplierRepository agentSupplier;
	@GetMapping("/adViews")
	public List<AdViews> getAllAdsViews() {
		return agent.findAll();
	}
	
	@GetMapping("/adViews/{adId}")
	public List<Long> getUsersIdByAdId(@PathVariable(value = "adId") Long adId)
			throws ResourceNotFoundException {
		List<Long> usersId = agent.findByAdId(adId);
		return usersId;
	}

	@PostMapping("/adViews")
	public AdViews createSupplier(@Valid @RequestBody AdViews adViews)
    throws ResourceNotFoundException {
		return agent.save(adViews);
	}


}
