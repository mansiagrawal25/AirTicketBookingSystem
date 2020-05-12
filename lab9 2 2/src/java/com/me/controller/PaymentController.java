/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.FlightDao;
import com.me.dao.PassengerDao;
import com.me.dao.TicketDao;
import com.me.pojo.FlightDetail;
import com.me.pojo.Passenger;
import com.me.pojo.Payment;
import com.me.pojo.Ticket;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mansiagrawal
 */
@Controller
@RequestMapping(value = "/*payment*.htm")
public class PaymentController {
    
    @Autowired
	@Qualifier("passengerDao")
	PassengerDao passengerDAO;
        @Autowired
		@Qualifier("flightDao")
		FlightDao flightDAO;
        @Autowired
      @Qualifier("ticketDao")
		TicketDao ticketDAO;
    
    @RequestMapping(value = "/payment.htm", method = RequestMethod.GET)
	public String initialize(@ModelAttribute("payment") Payment payment) {
		
		
		return "payment";
	}
        @RequestMapping(value = "/payment.htm", method = RequestMethod.POST)
	public String addPayment(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		long passenger_id = ((Long) session.getAttribute("passenger_id"));

		try {

			String number = request.getParameter("creditCardNumber");
//			number = number.replaceAll("[^0-9]", "");
			long creditCardNumber = Long.parseLong(number);
			
			String bankName = request.getParameter("bankName");
//			bankName = bankName.replaceAll("[^\\dA-Za-z]", "");
			String fullName = request.getParameter("fullName");
//			fullName = fullName.replaceAll("[^A-Za-z]+$", "");
			String expiration_month = request.getParameter("expiration_month");
//			expiration_month = expiration_month.replaceAll("[^0-9]", "");
			Cookie exp_month = new Cookie("month", expiration_month);
			String expiration_year = request.getParameter("expiration_year");
//			expiration_year = expiration_year.replaceAll("[^0-9]", "");
			Cookie exp_year = new Cookie("year", expiration_year);
			Payment paymnt = passengerDAO.createPayment(creditCardNumber, bankName, fullName, expiration_month,
					expiration_year);

			passengerDAO.updatePassenger(passenger_id, paymnt);

			Passenger passenger = passengerDAO.searchPassenger(passenger_id);
			FlightDetail flightDetail = (FlightDetail) session.getAttribute("flight");

			Ticket t=ticketDAO.bookTicket(passenger, flightDetail);
			int availSeats = flightDetail.getAvailableSeats();
			flightDAO.updateAvailableSeats(flightDetail, availSeats, availSeats-1);
			//flightDetail.setAvailableSeats(availSeats - 1);
			
			response.addCookie(exp_month);
			response.addCookie(exp_year);
                        session.setAttribute("ticket", t);

		} catch (Exception e) {
			System.out.println("Could not add payment/ticket" + e.getMessage());
		}

		return "printTicket";
	}
}
