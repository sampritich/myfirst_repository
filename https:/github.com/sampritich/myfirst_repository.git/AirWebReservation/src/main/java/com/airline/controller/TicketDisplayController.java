package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.TicketBo;
import com.airline.model.Ticket;
import com.airline.model.VisaInformation;

/**
 * Servlet implementation class TicketDisplayController
 */
public class TicketDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		
		
		
		Ticket ticket=(Ticket)session.getAttribute("ticketwithpassenger");
		System.out.println(ticket.getPassengerCount());
		//System.out.println(ticket.getTicketId());
		String button=request.getParameter("next");
		
		System.out.println(button);
		
		
		if(request.getParameter("checkout")!=null) {
			System.out.println(request.getParameter("checkout"));
			
			TicketBo ticketBO = new TicketBo();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);
			System.out.println("After Booked");
			
			if(status) {
				RequestDispatcher dispatch=request.getRequestDispatcher("bookingsuccess.jsp");
				dispatch.forward(request, response);
			}
			
			}
		if(request.getParameter("next")!=null) {
		String country=request.getParameter("country");
		
		String issueDate=request.getParameter("issuedate");
		
		String expiryDate=request.getParameter("expirydate");
		
		String visaNumber=request.getParameter("number");
		
		System.out.println(issueDate);
		
		System.out.println(expiryDate);
		
		System.out.println(visaNumber);
		
		
		VisaInformation visa=new VisaInformation();
		
		visa.setCountry(country);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
		Date issue=null;
		try {
			issue = sdf.parse(issueDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		visa.setDateOfIssue(issue);
		System.out.println(issue+"issuedate");
		SimpleDateFormat sdf1=new SimpleDateFormat("dd MMM yyyy");
		
		Date expiry=null;
		
		try {
			expiry=sdf1.parse(expiryDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		visa.setDateOfExpiry(expiry);
		visa.setVisaIdentityNumber(visaNumber);
		ticket.setVisa(visa);
		
		System.out.println(ticket.getVisa().getCountry()+"visa");
		

		Float price=(Float)session.getAttribute("price");
		System.out.println(price);
		int passengerCount=ticket.getPassengerCount();
		
		float totalAmount=passengerCount*price;
		
		System.out.println(totalAmount+"to be paid");
		
		session.setAttribute("totalAmount", totalAmount);

		
		
		
		RequestDispatcher dispatch=request.getRequestDispatcher("checkout.jsp");
		dispatch.forward(request, response);
		
		
		
	}
		
			}
}
