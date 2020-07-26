package com.consommi.tounsi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.models.ModelKPI;
import com.consommi.tounsi.services.Statistics;

@RestController
@RequestMapping("/api/v1")
public class StatisticsController {
	@Autowired
	Statistics agent;
	
	@GetMapping("/modelKPI")
	public ModelKPI getNbUsers() {
		return agent.JPQLQuery();
	}
}
