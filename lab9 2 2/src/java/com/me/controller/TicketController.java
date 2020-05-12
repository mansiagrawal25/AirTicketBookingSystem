/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.lowagie.text.Document;
import com.me.dao.PassengerDao;
import com.me.dao.TicketDao;
import com.me.pojo.FlightDetail;
import com.me.pojo.Passenger;
import java.io.ByteArrayOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author mansiagrawal
 */

@Controller
@RequestMapping(value="/*ticket*")
public class TicketController {
     @Autowired
		@Qualifier("ticketDao")
		TicketDao ticketDAO;
         @Autowired
	@Qualifier("passengerDao")
	PassengerDao passengerDAO;
//         
         @RequestMapping(value="/downloadTicket.pdf", method=RequestMethod.GET)
	public void downloadTicket(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		long passenger_id = ((Long) session.getAttribute("passenger_id"));
		Passenger passenger = passengerDAO.searchPassenger(passenger_id);
		//Payment payment = (Payment)session.getAttribute("payment");
		FlightDetail flightDetail = (FlightDetail)session.getAttribute("flight");
		
		
		try{
		
		response.setContentType("application/pdf");
		
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        Paragraph title = new Paragraph("Ticket Confirmation");
        Paragraph name = new Paragraph("Passenger name:"+passenger.getFirstName()+""+passenger.getLastName());
        Paragraph flight = new Paragraph("Flight Name"+flightDetail.getFlight_name()+" From "+flightDetail.getFrom()+" Destination "+flightDetail.getDest());
        Paragraph deptDetails = new Paragraph("Departure Date"+flightDetail.getDeptDate()+"Departure Time :"+flightDetail.getDeptTime());
        Paragraph arrDetails = new Paragraph("Destination Arrival Date"+flightDetail.getArrDate()+"Destination Arrival Time"+flightDetail.getArrivalTime());
        
        document.add(title);
        document.add(name);
        document.add(flight);
        document.add(deptDetails);
        document.add(arrDetails);
        
        document.close();
        
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
        
        
		}
		
		catch(Exception e)
		{
			System.out.println("Could not add ticket object"+e.getMessage());
		}
		
	}
         @RequestMapping(value="/emailTicket.htm", method=RequestMethod.GET)
	public String emailTicket(HttpServletRequest request) throws Exception
	{
		try{
	
		HttpSession session = request.getSession();
		long passenger_id = ((Long) session.getAttribute("passenger_id"));
		Passenger passenger = passengerDAO.searchPassenger(passenger_id);
		//Payment payment = (Payment)session.getAttribute("payment");
		FlightDetail flightDetail = (FlightDetail)session.getAttribute("flight");
		
		String from = "webtools1944@gmail.com";
        String host = "smtp.gmail.com";
        String to = passenger.getEmail();
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.starttls.enable","true");//starts TLS connection
        properties.put("mail.smtp.auth", "true");
        Authenticator auth = new SMTPAuthenticator();
        Session sess = Session.getDefaultInstance(properties,auth);
        
        // Create a default MimeMessage object - MIME supports email format
        MimeMessage message = new MimeMessage(sess);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        
        // Setting Subject
        message.setSubject("Airline Reservation System");
        
        //The actual Message
        message.setText( "Hello,Passenger:"+passenger.getFirstName()+" "+passenger.getLastName()+"\n"
        			+"Thank you for booking Ticket with us. Please find your flight details below "+"\n"
        			+"Flight Name"+flightDetail.getFlight_name()+" From "+flightDetail.getFrom()+" Destination "+flightDetail.getDest()+"\n"
        			+"Departure Date"+flightDetail.getDeptDate()+"Departure Time :"+flightDetail.getDeptTime()+"\n"
        			+"Destination Arrival Date"+flightDetail.getArrDate()+"Destination Arrival Time"+flightDetail.getArrivalTime());
        
        Transport.send(message);
        System.out.println("Sent message successfully");
        
        
        
		}
		catch(Exception e)
		{
			System.out.println("Could not send email "+e.getMessage());
		}
		
		return "confirmation";
	}
	@RequestMapping(value="/deleteTicket.htm", method=RequestMethod.GET)
	public String deleteTicket(HttpServletRequest request) throws Exception
	{
		try{
		HttpSession session = request.getSession();
		long passenger_id = ((Long) session.getAttribute("passenger_id"));
		Passenger passenger = passengerDAO.searchPassenger(passenger_id);
		FlightDetail flightDetail = (FlightDetail)session.getAttribute("flightdetail");
		ticketDAO.cancelTicket(passenger, flightDetail);
		
		
		}
		catch(Exception e)
		{
			System.out.println("Could not cancel Ticket "+e.getMessage());
		}
		
		return "confirmation";
	}
}
