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
import com.consommi.tounsi.models.Ad;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.repository.AdRepository;
import com.consommi.tounsi.repository.SupplierRepository;

@RestController
@RequestMapping("/api/v1")
public class AdController {

	@Autowired
	AdRepository agent;
	@Autowired
	SupplierRepository agentSupplier;
	@GetMapping("/ad")
	public List<Ad> getAllAds() {
		return agent.findAll();
	}
	@GetMapping("/ad/{id}")
	public ResponseEntity<Ad> getAdById(@PathVariable(value = "id") Long adId)
			throws ResourceNotFoundException {
		Ad ad = agent.findById(adId)
				.orElseThrow(() -> new ResourceNotFoundException("Ad not found for this id :: " + adId));
		return ResponseEntity.ok().body(ad);
	}

	@PostMapping("/ad/{supplierid}")
	public Ad createAd(@Valid @RequestBody Ad ad,@PathVariable(value = "supplierid")
	Long supplierId) throws ResourceNotFoundException {
		Supplier supplier = agentSupplier.findById(supplierId)
				.orElseThrow(() -> new ResourceNotFoundException("Supplier not found:: " + supplierId));
		ad.setSupplier(supplier);
		return agent.save(ad);
	}

	@PutMapping("/ad/{id}")
	public ResponseEntity<Ad> updateAd(@PathVariable(value = "id") Long adId,
			@Valid @RequestBody Ad adDetails) throws ResourceNotFoundException {
		Ad ad = agent.findById(adId)
				.orElseThrow(() -> new ResourceNotFoundException("Ad not found for this id :: " + adId));

		prepObj(adDetails, ad);
		final Ad updatedAd = agent.save(ad);
		return ResponseEntity.ok(updatedAd);
	}
	
	public void prepObj(Ad adDetails,Ad ad) {

		if (!adDetails.getTitle().equals("")) {
			ad.setTitle(adDetails.getTitle());
		}
		if (!adDetails.getType().equals("")) {
			ad.setType(adDetails.getType());
		}
		if (adDetails.getStartDate()!=null) {
			ad.setStartDate(adDetails.getStartDate());
		}
		if (adDetails.getEndDate()!=null) {
			ad.setEndDate(adDetails.getEndDate());
		}
		if (adDetails.getEstimatedViewNumber()!=0) {
			ad.setEstimatedViewNumber(adDetails.getEstimatedViewNumber());
		}
		if (adDetails.getActualViewNumber()!=0) {
			ad.setActualViewNumber(adDetails.getActualViewNumber());
		}
		if (adDetails.getCost()!=0) {
			ad.setCost(adDetails.getCost());
		}
		ad.setIsValid(adDetails.getIsValid());
	}
	
	@DeleteMapping("/ad/{id}")
	public Map<String, Boolean> deleteAd(@PathVariable(value = "id") Long adId)
			throws ResourceNotFoundException {
		Ad ad = agent.findById(adId)
				.orElseThrow(() -> new ResourceNotFoundException("Ad not found for this id :: " + adId));
		agent.delete(ad);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
