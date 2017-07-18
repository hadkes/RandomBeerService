package com.distrilledsch.randombeer.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "beer")
public class Beer{
	@Id
	@Column (name = "id", nullable = false, unique = true)
	private String id;

	@Column (name = "name")
	private String name;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "cost")
	private double cost;
	
	@Column (name = "alcohol_percentage")
	private double alcoholPercentage;

	// provider is mandatory field
	@ManyToOne (cascade = CascadeType.ALL)
	private Provider provider;


	public Beer() {
		// default constructor
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id == null){
			throw new IllegalArgumentException("Beer id cannot be null.");
		}
		if(id.trim().length() == 0){
			throw new IllegalArgumentException("Beer id cannot be empty.");
		}
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null){
			throw new IllegalArgumentException("Beer name cannot be null.");
		}
		if(name.trim().length() == 0){
			throw new IllegalArgumentException("Beer name cannot be empty.");
		}
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		// cost can be 0.0 assuming a promotion
		this.cost = cost;
	}

	public void setProvider(Provider provider) {
		if(provider == null) {
			throw new IllegalArgumentException("Provider name cannot be null.");
		}
		this.provider = provider;
	}
	public Provider getProvider() {
		return provider;
	}

	public double getAlcoholPercentage(){
		return alcoholPercentage;
	}
	public void setAlcoholPercentage(double alcoholPercentage){
		// typically beer alcohol percentage is not greater than 10.0 per http://getdrunknotfat.com/alcohol-content-of-beer/
		// Beer such as Kirin Free can have no alcohol.
		if(alcoholPercentage < 0.0 || alcoholPercentage > 10.0){
			throw new IllegalArgumentException("Alcohol content of beer should be within rage of 0.0 to 10.0 percentage.");
		}
		this.alcoholPercentage = alcoholPercentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
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
		Beer other = (Beer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		return true;
	}
}
