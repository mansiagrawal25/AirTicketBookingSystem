/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.validator;

import com.me.pojo.Person;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author mansiagrawal
 */
public class PersonValidator implements Validator {
    
    public boolean supports(Class aClass) {
		return aClass.equals(Person.class);
	}

	public void validate(Object obj, Errors errors) {
		Person user = (Person) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "password Required");
		
		// check if user exists
	}
        
	
}
