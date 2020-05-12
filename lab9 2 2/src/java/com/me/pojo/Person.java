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
@Table(name="person")
public class Person {
       
   
    	@Id 
	@GeneratedValue
	@Column(name="id", unique = true, nullable = false)
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
	String role;
    public Person() {
        
    }
    public Person(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
        
    }

    public Person(Person u) {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
}
