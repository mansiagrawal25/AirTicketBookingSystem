/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.exception;

/**
 *
 * @author mansiagrawal
 */
public class PersonException extends Exception {
    public PersonException(String message)
	{
		super("PersonException-"+message);
	}
	
	public PersonException(String message, Throwable cause)
	{
		super("PersonException-"+message,cause);
	}
}
