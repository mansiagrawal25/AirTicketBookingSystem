/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Flight;
import com.me.pojo.FlightDetail;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author mansiagrawal
 */
public class FlightDao extends DAO{
    public Flight create(String title) {
   
            begin();
            Flight cat = new Flight(title);
            getSession().save(cat);
            commit();
            return cat;
        
    }
    public FlightDetail createFlight(String flight_name,long airplane_id, String from, String dest, String deptTime,
			String arrivalTime, String travelClass, int totalSeats, int availableSeats, int amount, String deptDate, String arrDate
			) throws Exception
	{
		try{
		begin();	
		FlightDetail fd = new FlightDetail(flight_name,airplane_id, from, dest, deptTime,
				arrivalTime, travelClass, totalSeats,availableSeats, amount, deptDate, arrDate
				);
		getSession().save(fd);
		commit();
		System.out.println("Added flight and available seats are"+fd.getAvailableSeats());
		return fd;
		}
		catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating new flight: " + e.getMessage());
        }    finally{
			close();
		}    
	}
    public List<FlightDetail> list() throws Exception{
    	
    	try {
            begin();
            Query q = getSession().createQuery("from FlightDetail");
            List<FlightDetail> adverts = q.list();
            System.out.println(adverts);
            commit();
            return adverts;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete advert", e);
        }
    	
    }
    public FlightDetail searchFlightByID(int flight_id) throws Exception {
        try {
        	
            begin();
            Query q = getSession().createQuery("from FlightDetail where flight_id = :flight_id");
            q.setLong("flight_id", flight_id);
            FlightDetail fd = (FlightDetail) q.uniqueResult();
            System.out.println("DAO available seats"+fd.getAvailableSeats());
            System.out.println("others**********"+fd.getFlight_name()+fd.getFlight_id());
            commit();
            return fd;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the flight details whose id is: " + flight_id + " " + e.getMessage());
        }
        finally{
			close();
		}
        
    }
    public void updateFlight(FlightDetail flight) throws Exception
	{
//	
            try {
            begin();
            getSession().update(flight);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not save the category", e);
        }
	}
    public void deleteFlight(FlightDetail flight)
            throws Exception {
        try {
            begin();
            getSession().delete(flight);
            commit();
            getSession().flush();
            getSession().clear();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete flight", e);
        }finally{
			close();
		}
    }
    public List listFlights(String fromPlace, String dest, String deptDate)throws Exception{
	
		List<String> list= null;
		
		try{
			begin();
			Query q = getSession().createQuery("from FlightDetail where fromPlace = :fromPlace and dest=:dest and deptDate=:deptDate");
			q.setString("fromPlace", fromPlace);
			q.setString("dest", dest);
			q.setString("deptDate", deptDate);
			
			list = q.list();
			commit();
			return list;
		}
	
		catch(HibernateException e){
			rollback();
            throw new Exception("Could not find any flights", e);
		}finally{
			close();
		}
		
}
    
    
    public void updateAvailableSeats(FlightDetail flight, int oldTotal, int newTotal) throws Exception
	{
		try {
            begin();
            
            	int oldAvail = flight.getAvailableSeats();
				System.out.println("Old Seats available are"+flight.getAvailableSeats());
				flight.setAvailableSeats(newTotal-(oldTotal-oldAvail));
				System.out.println("Available seats are "+flight.getAvailableSeats());
				
			getSession().update(flight);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not update flight", e);
        }finally{
			close();
		}
	}
    
     public List<FlightDetail> listf(int firstResult, int maxResults) throws Exception{
    	
    	try {
            // int paginatedCount = 0;
            begin();
            Query q = getSession().createQuery("from FlightDetail");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            
            List<FlightDetail> flight = q.list();
           // paginatedCount = products.size();
            commit();
            
            return flight;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not fetch products", e);
        }
        }
}

