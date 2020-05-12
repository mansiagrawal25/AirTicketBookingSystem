/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.PassengerDao;
import com.me.dao.TicketDao;
import com.me.pojo.Passenger;
import com.me.pojo.Person;
import com.me.pojo.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mansiagrawal
 */
@Controller
@RequestMapping(value="/*passenger*.htm")
public class PassengerController {
    @Autowired
	@Qualifier("passengerDao")
	PassengerDao passengerDAO;
       @Autowired
      @Qualifier("ticketDao")
		TicketDao ticketDAO;
    
    @RequestMapping(value = "/passenger1.htm", method = RequestMethod.GET)
	public String checkUserInSession(HttpServletRequest request, @ModelAttribute("passenger") Passenger passenger,BindingResult result ) {

		HttpSession session = request.getSession();
		Person username = (Person) session.getAttribute("person");
		System.out.println(username);

		if (username == null) {
			return "message";
		}

		else {
			return "passenger";
		}

	}
    
    @RequestMapping(value="/passenger.htm", method=RequestMethod.GET)
	public String initialize(@ModelAttribute("passenger")Passenger passenger,HttpServletRequest request,BindingResult result)
	{
		HttpSession session = request.getSession();
		int noOfTravellers=1;
		session.setAttribute("noOfTravellers",noOfTravellers);
		return "passenger";
	}
        
        
	@RequestMapping(value="/passenger.htm", method=RequestMethod.POST)
	public String doSubmit(@ModelAttribute("passenger")Passenger passenger,BindingResult result, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
//		validator.validate(passenger, result);
//    	if(result.hasErrors()){
//    		return "passenger"; 
//    	}
    	
		try{
	
			String firstName=passenger.getFirstName(); 
			firstName = firstName.replaceAll("[^A-Za-z]+$", "");
			String lastName=passenger.getLastName(); 
//			lastName = lastName.replaceAll("[^A-Za-z]+$", "");
			String gender=passenger.getGender(); 
			String email=passenger.getEmail(); 
//			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//			         + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//			Matcher matcher = pattern.matcher(email);
			String dob=passenger.getDob(); 
			String phonenum=passenger.getPhonenum();
			phonenum = phonenum.replaceAll("[^0-9]", "-");
			String address=passenger.getAddress();
			
			Passenger pas = passengerDAO.createPassenger(firstName,lastName,gender,email,dob,phonenum,address);
			long passenger_id = pas.getId(); 
			session.setAttribute("passenger_id", passenger_id);
			
		}
		catch(Exception e)
		{
			System.out.println("Could not create Passenger"+e.getMessage());
		}
		
		//Payment payment = new Payment();
		
		return "payment";
	}
	
	@RequestMapping(value="/viewpassengers.htm", method=RequestMethod.GET)
	public ModelAndView viewPassenger(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<Ticket> ticketList= new ArrayList<Ticket>();
		try{
			ticketList = ticketDAO.TicketList();
			System.out.println("----->"+ticketList.size());
                        for(Ticket u: ticketList){
                            System.out.println(u.getFlightDetails().getDeptDate());
                            
                        }
                        
		   }
                
               
		catch(Exception e)
		{
			System.out.println("Could not list passengers"+e.getMessage());
		}
		ModelAndView mv = new ModelAndView("passengerList", "ticketList", ticketList);
        return mv;
	}
	
}
