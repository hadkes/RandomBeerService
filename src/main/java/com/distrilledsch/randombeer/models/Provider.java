package com.distrilledsch.randombeer.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "provider")
public final class Provider{
	
	@Id
	@Column (name = "name", nullable = false, unique = true)
	private String name;
	
	@Embedded
	private Address address;

	public Provider() {
		// default constructor
	}

	public void setName(String name) {
		// validate name
		if (name == null) {
			throw new IllegalArgumentException("Provider name cannot be null.");
		}
		if (name.trim().length() == 0) {
			throw new IllegalArgumentException("Provider name cannot be empty.");
		}
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	public void setAddress(Address address) {
		// validate address
		if (address == null) {
			throw new IllegalArgumentException("Provider address cannot be null.");
		}
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Provider other = (Provider) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
