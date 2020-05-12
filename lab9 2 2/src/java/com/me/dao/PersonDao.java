/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;
import com.me.exception.PersonException;
import com.me.pojo.Person;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author mansiagrawal
 */
public class PersonDao extends DAO {
    public Person register(Person u){

			begin();
			System.out.println("inside DAO");

			Person user = new Person(u.getName(), u.getPassword() ,u.getRole());
			getSession().save(user);
			commit();
			return user;

		
	}
    public Person get(String name, String password) throws PersonException{
	
			try {
			begin();
			Query q = getSession().createQuery("from Person where name = :name and password = :password");
			q.setString("name", name);
			q.setString("password", password);			
			Person user = (Person) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new PersonException("Could not get user " + name, e);
		}
	
	}
    public boolean validateAdmin(String name,String password) throws PersonException
	{
		try{
			
			
			Query q = getSession().createSQLQuery("select * from person where name=:name and password=:password and role='ADMIN'");
			q.setString("name", name);
			q.setString("password",password);
		    Object obj = q.uniqueResult();
		    if(obj==null)
		    {
		    	return false;
		    }
			
			
		}
		catch(HibernateException e){
			rollback();
            throw new PersonException("Could not find any user", e);
		}finally{
			close();
		}
	
		
		
		return true;
		
	}
    
	public boolean validateUser(String name,String password) throws PersonException
	{
		try{
			
			
			Query q = getSession().createSQLQuery("select * from Person where name=:name and password=:password and role='customer'");
			q.setString("name", name);
			q.setString("password",password);
		    Object obj = q.uniqueResult();
                     if(obj==null)
		    {
		    	return false;
		    }
			
			
		}
		catch(HibernateException e){
			rollback();
            throw new PersonException("Could not find any user", e);
		}
		
		return true;
		
	}
	
	 public boolean userExists(String name)
	{
		try{
			begin();
			Query q = getSession().createQuery("From Person where name=:name");
			q.setString("name", name);
			List list = q.list();
			commit();
			
			if(list.size()==0)
			{
				return false;
			}
			
			
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		finally{
			close();
		}
		return true;
	}
	
}
