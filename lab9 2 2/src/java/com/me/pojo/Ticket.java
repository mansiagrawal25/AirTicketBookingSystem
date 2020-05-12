/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mansiagrawal
 */
@Entity
@Table(name="ticket")
public class Ticket {
    @Id 
	@GeneratedValue
	@Column(name="ticket_id", unique = true, nullable = false)
	long ticket_id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="passenger_id")
	Passenger passengerDetails;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="flight_id")
	FlightDetail flightDetails;
	
    Ticket() {
		
	}
	
	
	public Ticket(Passenger passengerDetails, FlightDetail flightDetails) {
		
		
		this.passengerDetails = passengerDetails;
		this.flightDetails = flightDetails;
	}

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Passenger getPassengerDetails() {
        return passengerDetails;
    }

    public void setPassengerDetails(Passenger passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    public FlightDetail getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetail flightDetails) {
        this.flightDetails = flightDetails;
    }
        
}
