/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author mansiagrawal
 */
public class SMTPAuthenticator extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication()
{
    String name = "webtools1994@gmail.com";
    String password = "webtool@123";
    return new PasswordAuthentication(name, password);
}}
