package com.lchhung.vehicles.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerId;
	private String firstName, lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
	@JsonIgnore
	private List<Car> cars;
	
	public Owner() {}
	
	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public long getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	
	public String getLastname() {
		return lastName;
	}
	
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	
	
}
