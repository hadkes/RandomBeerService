package com.distrilledsch.randombeer.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column (name = "address1")
	private String address1;
	
	@Column (name = "address2")
	private String address2;
	
	@Column (name = "state")
	private String state;
	
	@Column (name = "country")
	private String country;

	public Address() {
		// default constructor
	}
	
	public void setAddress1(String address1) {
		// validate address 1
		if (address1 == null) {
			throw new IllegalArgumentException("Address street or area cannot be null.");
		}
		if (address1.trim().length() == 0) {
			throw new IllegalArgumentException("Address street or area cannot be empty.");
		}
		this.address1 = address1;
	}
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress2(String address2) {
		// address 2 can be null
		this.address2 = address2;
	}
	public String getAddress2() {
		return address2;
	}
	
	public void setState(String state) {
		// validate state
		if (state == null) {
			throw new IllegalArgumentException("Address state cannot be null.");
		}
		if (state.trim().length() == 0) {
			throw new IllegalArgumentException("Address state cannot be empty.");
		}

		this.state = state;
	}
	public String getState() {
		return state;
	}
	
	public void setCountry(String country) {
		// validate country
		if (country == null) {
			throw new IllegalArgumentException("Address country cannot be null.");
		}
		if (country.trim().length() == 0) {
			throw new IllegalArgumentException("Address country cannot be empty.");
		}
		this.country = country;
	}
	public String getCountry() {
		return country;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", state=" + state + ", country="
				+ country + "]";
	}
}
