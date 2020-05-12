package com.me.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.me.exception.UserException;
import com.me.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String name, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where name = :name and password = :password");
			q.setString("name", name);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + name, e);
		}
	}
	
	public User get(int id) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where id= :id");
			q.setInteger("id", id);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + id, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			User user = new User(u.getName(), u.getPassword());
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getName(), e);
		}
	}
}