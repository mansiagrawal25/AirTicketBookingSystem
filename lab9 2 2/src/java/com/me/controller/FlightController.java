/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.FlightDao;
import com.me.pojo.Flight;
import com.me.pojo.FlightDetail;
import com.me.pojo.Person;
import com.me.pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/flight/*")
public class FlightController {
    @Autowired
		@Qualifier("flightDao")
		FlightDao flightDAO;
        private static int startpoint = 1;
    private static int pagesize = 3;
    private static int pagecount = 1;
    
//    @RequestMapping(value = "/flight/add", method = RequestMethod.GET)
//   public ModelAndView initializeForm(HttpServletRequest request) throws Exception {	
//                    HttpSession session = (HttpSession) request.getSession();
//                    User user = (User)session.getAttribute("user");
//                    if (user == null) {
//                        return new ModelAndView("login-user");
//                    }
//		    return new ModelAndView("flight-form", "flight", new Flight());
//   }
   @RequestMapping(value = "/flight/add", method = RequestMethod.GET)
   public ModelAndView initializeForm(HttpServletRequest request) throws Exception {	
                    HttpSession session = (HttpSession) request.getSession();
                    Person user = (Person)session.getAttribute("person");
                    if (user == null) {
                        return new ModelAndView("login-user");
                    }
		    return new ModelAndView("flight-form", "flight", new FlightDetail());
   }

   @RequestMapping(value = "/flight/add", method = RequestMethod.POST)
   	protected String doSubmitAction(@ModelAttribute("flight") FlightDetail fd,BindingResult result) throws Exception
	{
//		
//		validator.validate(fd, result);
//    	if(result.hasErrors()){
//    		return "addFlights"; 
//    	}
    	
    	try
        {
    		long airplane_id = fd.getAirplane_id(); 
    		String from=fd.getFrom(); 
//    		from = from.replaceAll("[^A-Za-z]+$", "");
    		String dest=fd.getDest(); 
//    		dest = dest.replaceAll("[^A-Za-z]+$", dest);
    		String deptTime=fd.getDeptTime();
//    		deptTime = deptTime.replaceAll("[^\\d:]", "");
    		String arrivalTime=fd.getArrivalTime(); 
//    		arrivalTime = arrivalTime.replaceAll("[^\\d:]", "");
    		String travelClass=fd.getTravelClass();
//    		travelClass = travelClass.replaceAll("[^A-Za-z]+$", "");
    		int totalSeats=fd.getTotalSeats(); 
    		int amount=fd.getAmount();
    		String deptDate=fd.getDeptDate(); 
    		String arrDate=fd.getArrDate(); 
    		String flight_name=fd.getFlight_name();
    		
    		
//            FlightDao fdao = new FlightDao();
            FlightDetail flight = flightDAO.createFlight(flight_name,airplane_id,from,dest,deptTime,arrivalTime,travelClass,totalSeats,totalSeats,amount,deptDate,arrDate);
            //DAO.close();
            
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        
    	
		return "adminHome";
	}
        
        @RequestMapping(value="/flight/list", method=RequestMethod.GET)
	public ModelAndView listForm(HttpServletRequest request){
//	{
//		
        try {			
				List<FlightDetail> flight = flightDAO.list();
                               
				return new ModelAndView("ListFlights", "flight", flight);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "error while login");
			}}
        
        
                @RequestMapping(value = "/flight/pagination", method = RequestMethod.GET)
		public ModelAndView GetFlightPageWise(HttpServletRequest request) throws Exception {
                        
			try {	
                           List<FlightDetail> flight;
                             pagecount++;
                            startpoint = (pagesize * pagecount) + 1 ;
                          
                            flight = flightDAO.listf(startpoint,pagesize);   
                           System.out.println("flight "+flight.size());
			    return new ModelAndView("ListFlights", "flight", flight);
				
			} catch (Exception e) {
                            System.out.println(e.getMessage());
                            return new ModelAndView("error", "errorMessage", "error while fetching products");
			}
			
                }
        
        @RequestMapping(value="/updateFlights.htm", method=RequestMethod.GET)
	public String updateFlights(@ModelAttribute("fd") FlightDetail fd, HttpServletRequest request) throws Exception
	{
		String id = request.getParameter("id");
		int flight_id = Integer.parseInt(id);
		
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		if(action!=null){
		if(action.equalsIgnoreCase("update"))
		{
			FlightDetail flight = flightDAO.searchFlightByID(flight_id);
			//int oldAvailable = flight.getAvailableSeats();
		     request.setAttribute("flight", flight);
		   //session.setAttribute("oldAvailable", oldAvailable);
		   return "updateFlight";
		   
                }
		
		}
		return "ListFlights";
        }
        @RequestMapping(value="/updateFlight.htm", method=RequestMethod.POST)
	public String update(@ModelAttribute("flight") FlightDetail flight,BindingResult result, HttpServletRequest request)
	{
		//HttpSession session = request.getSession();
		
		try{
			
			flightDAO.updateFlight(flight);
			System.out.println("Now Seats available are"+flight.getAvailableSeats()+flight.getFlight_name());
			System.out.println("Flight saved/updated successfully");
			
		}
		catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
		
		return "adminHome";
	}
        @RequestMapping(value="/deleteFlights.htm", method=RequestMethod.GET)
	public String deleteFlights(@ModelAttribute("fd") FlightDetail fd, HttpServletRequest request) throws Exception
	{
		try{
			String id = request.getParameter("id");
			
			int flight_id = Integer.parseInt(id);
			
			HttpSession session = request.getSession();
			
			FlightDetail flight = flightDAO.searchFlightByID(flight_id);
			
//			tdao.deleteTickets(flight_id);
			
			flightDAO.deleteFlight(flight);
			
		}
		catch(Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
		
		return "adminHome";
	}
// 
//	
        @RequestMapping(value="/addToCart.htm", method=RequestMethod.GET)
	public String intialize(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException{
		
		try{
		HttpSession session = request.getSession();
		System.out.println("flight id" + request.getParameter("fid"));
		int flightid = Integer.parseInt(request.getParameter("fid"));
		System.out.println("Flight ID is"+flightid);
		List<FlightDetail> cart;
 
		FlightDetail fd = flightDAO.searchFlightByID(flightid);
		
		System.out.println("Cart Controller:"+fd.getAvailableSeats());
		
		int noOfSeats = fd.getAvailableSeats();
		PrintWriter out = response.getWriter();
		if(noOfSeats>0)
		{
			
			out.println("Seats are available");
			if (session.getAttribute("cart") != null) {
	             cart = (ArrayList<FlightDetail>) session.getAttribute("cart");
	         } else {
	             cart = new ArrayList<FlightDetail>();
	         }
			
			 cart.add(fd);
			 session.setAttribute("cart", cart);
			 session.setAttribute("flight", fd);
			 
			 float total = 0;
                         int quantity=0;
	         for (FlightDetail f : cart) {
                   
                 
	             total = total + f.getAmount();
	         }
	         
	         session.setAttribute("total", total);
	         
	         return "viewCart";
	         
			}
		
		else
		{
			
			return "notAvailable";
			
		}	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

}
        
        
        
        @RequestMapping(value="/removeFromCart.htm", method=RequestMethod.GET)
	public String removeItems(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		try{
			
			List<FlightDetail> cart =(ArrayList<FlightDetail>) session.getAttribute("cart");
			String id = request.getParameter("id");
			int flight_id = Integer.parseInt(id); 
			
			
			for(FlightDetail fd:cart){
				if(fd.getFlight_id()==flight_id){
					cart.remove(fd);
					break;
					
				}
			}
			
			session.setAttribute("cart", cart);
			
			 float total = 0;
	         for (FlightDetail f : cart) {
	             total = total + f.getAmount();
	         }
	         
	         session.setAttribute("total", total);
		}
		
		catch(Exception e)
		{
			System.out.println("Could not remove flight object"+ e);
		}
		
		
		return "viewCart";
	}
	
}
