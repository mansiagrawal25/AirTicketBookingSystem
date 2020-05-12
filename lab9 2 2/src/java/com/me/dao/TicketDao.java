/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.FlightDetail;
import com.me.pojo.Passenger;
import com.me.pojo.Ticket;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author mansiagrawal
 */
public class TicketDao extends DAO {
    
    public Ticket bookTicket(Passenger passengerDetails, FlightDetail flightDetails) throws Exception{
		
		
		try {
            begin();
            Ticket ticket = new Ticket(passengerDetails, flightDetails);   
            getSession().save(ticket);
            commit();
            return ticket;
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while creating ticket: " + e.getMessage());
        }  finally{
			close();
		}      

		
		
	}
    public List<Ticket> TicketList() throws Exception{
	try {
            begin();
            Query q = getSession().createQuery("from Ticket");
            List<Ticket> adverts = q.list();
            System.out.println(adverts);
            commit();
            return adverts;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete advert", e);
        }}
    public void cancelTicket(Passenger passengerDetails,FlightDetail flightDetails) throws Exception
	{
		try{
			begin();
			long passenger_id = passengerDetails.getId();
			long flight_id = flightDetails.getFlight_id();
			Query q = getSession().createQuery("From Ticket where passenger_id=:passenger_id and flight_id=:flight_id");
			q.setLong("passenger_id",passenger_id);
			q.setLong("flight_id",flight_id);
			Ticket ticket = (Ticket)q.uniqueResult();
			getSession().delete(ticket);
			
			
			int oldAvail = flightDetails.getAvailableSeats();
			flightDetails.setAvailableSeats(oldAvail+1);
			getSession().update(flightDetails);
			
			commit();
		}
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while deleting ticket: " + e.getMessage());
        } 
		finally{
			close();
		}
	}
	
}
