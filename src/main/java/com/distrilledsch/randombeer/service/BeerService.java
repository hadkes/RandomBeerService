package com.distrilledsch.randombeer.service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distrilledsch.randombeer.models.Beer;
import com.distrilledsch.randombeer.repository.BeerRepository;

@Service
public class BeerService {
	private static final Logger logger = LoggerFactory.getLogger(BeerService.class);
	
	@Autowired
	private BeerRepository beerRepository;

	public void saveBeer(Beer beer) {
		logger.debug("Saving beer with details: "+beer);
				
		// update beer object and add random id
		String beerPrimaryKey = UUID.randomUUID().toString();
		logger.debug("Setting beer (name:"+beer.getName()+") primary key to: "+beerPrimaryKey);
		beer.setId(beerPrimaryKey);
		
		beerRepository.save(beer);
	}
	
	public Beer getRandomBeer() {
		Iterable<Beer> beers = beerRepository.findAll();
		List<Beer> array = StreamSupport.stream(beers.spliterator(), false).collect(Collectors.toList());
		Random r = new Random();
		int randomNumber = r.nextInt(array.size());
		return array.get(randomNumber);
	}
	
	public Set<Beer> getAllBeer(){
		return StreamSupport.stream(beerRepository.findAll().spliterator(), false).collect(Collectors.toSet());
	}
}
