/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Passenger;
import com.me.pojo.Payment;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author mansiagrawal
 */
public class PassengerDao extends DAO {
    public Passenger createPassenger(String firstName, String lastName, String gender, String email, String dob, String phonenum,
			String address) throws Exception
	{
		try{
			begin();
			Passenger passenger = new Passenger(firstName, lastName, gender, email, dob, phonenum,
					 address);
			getSession().save(passenger);
			commit();
			return passenger;
		}
		
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while creating new passenger: " + e.getMessage());
        }  
		finally{
			close();
		}
		
	}
    public Payment createPayment(long creditCardNumber, String bankName, String fullName, String expiration_month,
			String expiration_year)throws Exception
	{
		try{
			begin();
			Payment p = new Payment(creditCardNumber, bankName, fullName, expiration_month,
					 expiration_year);
			getSession().save(p);
			commit();
			return p;
		}
		
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while creating new payment: " + e.getMessage());
        }   
		finally{
			close();
		}
		
		
	}
    public void updatePassenger(long passenger_id, Payment payment) throws Exception
	{
		
		try{
			begin();
			Query query = getSession().createQuery("From Passenger where passenger_id=:passenger_id ");
			query.setLong("passenger_id", passenger_id);
			Passenger passenger = (Passenger)query.uniqueResult();
			passenger.setPayment(payment);
			getSession().update(passenger);
			commit();
			
		}
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while updating passenger: " + e.getMessage());
        }   
		finally{
			close();
		}
	}
    public Passenger searchPassenger(long passenger_id) throws Exception
	{
		Passenger passenger;
		try{
			begin();
			Query query = getSession().createQuery("From Passenger where passenger_id=:passenger_id ");
			query.setLong("passenger_id", passenger_id);
			passenger = (Passenger)query.uniqueResult();
			
			commit();
		}
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create flight", e);
            throw new Exception("Exception while searching passenger: " + e.getMessage());
        }  finally{
			close();
		}
		return passenger;
	}
	
}
