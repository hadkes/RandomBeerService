package com.distrilledsch.randombeer.service;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.distrilledsch.randombeer.models.Address;
import com.distrilledsch.randombeer.models.Beer;
import com.distrilledsch.randombeer.models.Provider;
import com.distrilledsch.randombeer.repository.BeerRepository;

public class BeerServiceTest {
	@Mock
	private BeerRepository beerRepository;
	
	@InjectMocks
	private BeerService beerService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testBookNullAppointment() {
		Address testAddress = new Address();
		testAddress.setAddress1("test address1");
		testAddress.setAddress2("test address2");
		testAddress.setState("test state");
		testAddress.setCountry("test country");
		
		Provider testProvider = new Provider();
		testProvider.setName("Test Provider");
		testProvider.setAddress(testAddress);
		
		Beer testBeer = new Beer();
		testBeer.setId("Test ID");
		testBeer.setName("Test Beer");
		testBeer.setDescription("Test desc");
		testBeer.setAlcoholPercentage(5.7);
		testBeer.setCost(4);
		testBeer.setProvider(testProvider);
		
		Set<Beer> testBeerSet = new HashSet<>();
		testBeerSet.add(testBeer);
		Iterable<Beer> iterable = () -> testBeerSet.iterator();
		
		Mockito.when(beerRepository.findAll()).thenReturn(iterable);
		
		Beer randomBeer = beerService.getRandomBeer();
		assertNotNull("Beer name cannot be null", randomBeer.getName());
		assertNotNull(randomBeer.getAlcoholPercentage());
		assertNotNull(randomBeer.getCost());
		assertNotNull("Beer id cannot be null", randomBeer.getId());
		assertNotNull("Beer provider cannot be null", randomBeer.getProvider());
		
		Provider provider = randomBeer.getProvider();
		assertNotNull("Beer provider name cannot be null", provider.getName());
		
		Address address = provider.getAddress();
		assertNotNull(address.getAddress1(), "Beer provider address1 cannot be null");
		assertNotNull(address.getState(), "Beer provider state cannot be null");
		assertNotNull(address.getCountry(), "Beer provider country cannot be null");
	}
}
