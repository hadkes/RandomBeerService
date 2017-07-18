package com.distrilledsch.randombeer.controllers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.distrilledsch.randombeer.models.Beer;
import com.distrilledsch.randombeer.service.BeerService;

@RestController
public class BeerController {
	private static final Logger logger = LoggerFactory.getLogger(BeerController.class);
	
	@Autowired
	private BeerService beerService;

	
	@RequestMapping (value = "/beer", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost")
	public void addBeer(@RequestBody Beer beer) {
		logger.debug("Request received to save a beer with name: "+beer.getName());
		beerService.saveBeer(beer);
	}
	
	@RequestMapping (value = "/randombeer", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost")
	public @ResponseBody Beer getRandomBeer() {
		return beerService.getRandomBeer();
	}
	
	@RequestMapping(value = "/beers", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8080")
	public @ResponseBody Set<Beer> getBeer() {
		logger.debug("Request received to fetch all bears.");
		return beerService.getAllBeer();
	}
}
