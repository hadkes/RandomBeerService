package com.distrilledsch.randombeer.model;

import com.distrilledsch.randombeer.models.Address;
import com.distrilledsch.randombeer.models.Beer;
import com.distrilledsch.randombeer.models.Provider;
import com.distrilledsch.randombeer.models.Review;

public class ObjectCreationFactory {
	public static final String reviewer = "Foo";
	public static final String review = "One of the best Irish beer.";
	public static final String name = "Guinness";
	public static final String address1 = "St James's Gate";
	public static final String address2 = "Ushers";
	public static final String state = "Dublin 8";
	public static final String country = "Ireland";
	
	public static final String beerName = "Guinness";
	public static final String description = "Irish beer";
	public static final double cost = 4.0;
	public static final double alcohol = 4.1;
	
	public static Review createReview(){
		Review reviewObj = new Review();
		reviewObj.setReviewer(reviewer);
		reviewObj.setReview(review);
		return reviewObj;
	}
	
	public static Address createAddress(){
		Address address = new Address();
		address.setAddress1(address1);
		address.setAddress2(address2);
		address.setState(state);
		address.setCountry(country);
		return address;
	}
	
	public static Provider createProvider(){
		Address address = createAddress();
		Provider provider = new Provider();
		provider.setName(name);
		provider.setAddress(address);
		return provider;
	}
	
	public static Beer createBeer(){
		Beer beer = new Beer();
		beer.setName(beerName);
		beer.setDescription(description);
		beer.setCost(cost);
		beer.setAlcoholPercentage(alcohol);
		beer.setProvider(createProvider());
		return beer;
	}
}
