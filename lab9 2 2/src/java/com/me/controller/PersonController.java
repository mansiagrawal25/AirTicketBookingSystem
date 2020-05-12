/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import org.json.JSONException;
import org.json.JSONObject;
import com.me.dao.PersonDao;
import com.me.exception.PersonException;
import com.me.pojo.Person;
import com.me.validator.PersonValidator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mansiagrawal
 */
@Controller
@RequestMapping("/person/*")
public class PersonController {
    
        @Autowired
		@Qualifier("personDao")
		PersonDao personDao;
        
        @Autowired
	@Qualifier("personValidator")
	PersonValidator personValidator;
        
        @InitBinder("person")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(personValidator);
	}
        
        @RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "user-home";
	}
   @RequestMapping(value = "/person/register", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("registerPerson");

		return new ModelAndView("register-person", "person", new Person());

	}
        


	@RequestMapping(value = "/person/register", method = RequestMethod.POST)
    
		public ModelAndView addPerson(HttpServletRequest request) throws Exception {
   System.out.println("inside Product DAO");
                    HttpSession session = (HttpSession) request.getSession();

                         String role = "customer";
                          String name = request.getParameter("name");
                           String password = request.getParameter("password");
                           if(personDao.userExists(request.getParameter("name"))){
                               return new ModelAndView("error");
                           }
                           else{
                           Person per=new Person(name,password,role);
                         Person p = personDao.register(per);
                         request.getSession().setAttribute("person", per);
//                    
	  
		   return new ModelAndView("userHome", "person", per);}
			
		}
                @RequestMapping(value = "/person/login", method = RequestMethod.GET)
        protected String loginUserHome(HttpServletRequest request) throws Exception {
		return "login-person";
	}
        
        @RequestMapping(value = "/person/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

           HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean flag=false;
		boolean check = false;
		try{
			
		flag = personDao.validateAdmin(name, password);
		check = personDao.validateUser(name, password);
		
		}
		catch(PersonException e){
		
			System.out.println("Exception: " + e.getMessage());
			
		}
		
		if(flag)
		{
                    Person u = personDao.get(request.getParameter("name"), request.getParameter("password"));
			System.out.println("Login successful" +u.getName());
			session.setAttribute("person", u);
			return new ModelAndView("adminHome");
			
		}
		
		else if(check){
			 Person u = personDao.get(request.getParameter("name"), request.getParameter("password"));
			System.out.println("Login successful");
			session.setAttribute("person", u);
//			return "userHome";
                         return new ModelAndView("userHome", "person", u);
			
		}
		else{
			return new ModelAndView("error");
		}
//		
		

	}
        @RequestMapping(value = "/person/logout", method = RequestMethod.GET)
	protected String logout(HttpServletRequest request) throws Exception {
            HttpSession session = (HttpSession) request.getSession();
            session.setAttribute("person", null);
            return "user-home";
        }
}
