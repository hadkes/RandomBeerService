package com.distrilledsch.randombeer.model;

import org.junit.Assert;
import org.junit.Test;

import com.distrilledsch.randombeer.models.Address;
import com.distrilledsch.randombeer.models.Provider;

public class ProviderTest {
	@Test
	public void testProvider(){
		Provider provider = ObjectCreationFactory.createProvider();
		Address address = provider.getAddress();
		
		Assert.assertEquals(provider.getName(), ObjectCreationFactory.name);
		Assert.assertEquals(address.getAddress1(), ObjectCreationFactory.address1);
		Assert.assertEquals(address.getAddress2(), ObjectCreationFactory.address2);
		Assert.assertEquals(address.getState(), ObjectCreationFactory.state);
		Assert.assertEquals(address.getCountry(), ObjectCreationFactory.country);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testProviderWithNullName(){
		Provider provider = new Provider();
		provider.setName(null);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testProviderWithEmptyName(){
		Provider provider = new Provider();
		provider.setName("");
	}
	
	@Test
	public void testAddress(){
		Address address = ObjectCreationFactory.createAddress();
		
		Assert.assertEquals(address.getAddress1(), ObjectCreationFactory.address1);
		Assert.assertEquals(address.getAddress2(), ObjectCreationFactory.address2);
		Assert.assertEquals(address.getState(), ObjectCreationFactory.state);
		Assert.assertEquals(address.getCountry(), ObjectCreationFactory.country);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithNullAddress1(){
		Address address = new Address();
		address.setAddress1(null);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithEmptyAddress1(){
		Address address = new Address();
		address.setAddress1("");
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithNullState(){
		Address address = new Address();
		address.setState(null);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithEmptyState(){
		Address address = new Address();
		address.setState("");
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithNullCountry(){
		Address address = new Address();
		address.setCountry(null);
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testAddressWithEmptyCountry(){
		Address address = new Address();
		address.setCountry("");
	}
	
	@Test
	public void testAddressWithVeriousAddress2(){
		Address address = new Address();
		address.setAddress1(ObjectCreationFactory.address1);
		address.setAddress2(null);
		address.setState(ObjectCreationFactory.state);
		address.setCountry(ObjectCreationFactory.country);
		
		Assert.assertEquals(address.getAddress1(), ObjectCreationFactory.address1);
		Assert.assertEquals(address.getAddress2(), null);
		Assert.assertEquals(address.getState(), ObjectCreationFactory.state);
		Assert.assertEquals(address.getCountry(), ObjectCreationFactory.country);
		
		address = new Address();
		address.setAddress1(ObjectCreationFactory.address1);
		address.setAddress2("");
		address.setState(ObjectCreationFactory.state);
		address.setCountry(ObjectCreationFactory.country);
		
		Assert.assertEquals(address.getAddress1(), ObjectCreationFactory.address1);
		Assert.assertEquals(address.getAddress2(), "");
		Assert.assertEquals(address.getState(), ObjectCreationFactory.state);
		Assert.assertEquals(address.getCountry(), ObjectCreationFactory.country);
	}
}
