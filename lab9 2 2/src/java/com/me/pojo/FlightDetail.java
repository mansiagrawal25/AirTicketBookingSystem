/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mansiagrawal
 */
@Entity
@Table(name="flightDetail")
public class FlightDetail {
    
    
	@Id
        @GeneratedValue
	@Column(name="flight_id")
	int flight_id;
	
	@Column(name="flight_name")
	String flight_name;
	
	@Column(name="airplane_id")
	long airplane_id;
	
	@Column(name="fromPlace")
	String from;
	
	@Column(name="dest")
	String dest;
	
	@Column(name="depttime")
	String deptTime;
	
	@Column(name="arrivaltime")
	String arrivalTime;
	
	@Column(name="travelClass")
	String travelClass;
	
	@Column(name="totalSeats")
	int totalSeats;
	
	@Column(name="availableSeats")
	int availableSeats;
	
	@Column(name="amount")
	int amount;
	
	
	@Column(name="deptDate")
	String deptDate;
	
	@Column(name="arrDate")
	String arrDate;

        public FlightDetail(){
            
        }
        public FlightDetail(String flight_name,long airplane_id, String from, String dest, String deptTime,
			String arrivalTime, String travelClass, int totalSeats, int availableSeats, int amount, 
			String deptDate, String arrDat) {
		
		this.airplane_id = airplane_id;
		this.from = from;
		this.dest = dest;
		this.deptTime = deptTime;
		this.arrivalTime = arrivalTime;
		this.travelClass = travelClass;
		this.totalSeats = totalSeats;
		this.amount = amount;
		this.deptDate = deptDate;
		this.arrDate = arrDat;
		this.flight_name = flight_name;
		this.availableSeats = availableSeats;
	}
    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public long getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(long airplane_id) {
        this.airplane_id = airplane_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }
	
	
    
}
