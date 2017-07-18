package com.distrilledsch.randombeer.model;

import org.junit.Assert;
import org.junit.Test;

import com.distrilledsch.randombeer.models.Beer;

public class BeerTest {
	@Test
	public void testBeer(){
		Beer beer = ObjectCreationFactory.createBeer();
		Assert.assertEquals(beer.getAlcoholPercentage(), ObjectCreationFactory.alcohol, 0.0);
		Assert.assertEquals(beer.getCost(), ObjectCreationFactory.cost, 0.0);
		Assert.assertEquals(beer.getDescription(), ObjectCreationFactory.description);
		Assert.assertEquals(beer.getName(), ObjectCreationFactory.name);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBeerWithNullName(){
		Beer beer = ObjectCreationFactory.createBeer();
		beer.setName(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBeerWithEmptyName(){
		Beer beer = ObjectCreationFactory.createBeer();
		beer.setName("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBeerWithNegativeAlcoholPercentage(){
		Beer beer = ObjectCreationFactory.createBeer();
		beer.setAlcoholPercentage(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBeerWithHighAlcoholPercentage(){
		Beer beer = ObjectCreationFactory.createBeer();
		beer.setAlcoholPercentage(11);
	}
}
