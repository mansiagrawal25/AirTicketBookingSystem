/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mansiagrawal
 */

@Entity
@Table(name="airplane_table")
public class Airplane {
    
	@Id 
	@GeneratedValue
	@Column(name="airplane_id", unique = true, nullable = false)
	private String airplane_id;
	
	@Column(name="airlineName")
	private String airlineName;
	
	
	@Column(name="owner")
	private String owner;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="airplane_id")
	private Set<Flight> flights = new HashSet<Flight>();
	
	
	
	public Airplane(){
		
	}


	public Airplane(String airlineName, String owner) {
		
		
		this.airlineName = airlineName;
		this.owner = owner;
	}

	

	public Set<Flight> getFlights() {
		return flights;
	}


	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}


	public String getAirplane_id() {
		return airplane_id;
	}


	public void setAirplane_id(String airplane_id) {
		this.airplane_id = airplane_id;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
