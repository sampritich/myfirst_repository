package com.airline.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.TicketBo;
import com.airline.model.*;
/**
 * Servlet implementation class TicketGenerateController
 */
public class TicketGenerateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketGenerateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatch = null;
		
		
		int passenger=(Integer)session.getAttribute("passenger");
		
		System.out.println(passenger+"count");
		Ticket ticket = (Ticket) session.getAttribute("ticket");

		
		String book = request.getParameter("Book");
		
	
		if(book!=null)
		{
			System.out.println("Passenger Details Taken");
			
			
			
			
			List<Passenger> list = new ArrayList<Passenger>();
			//List<SpecialService> specialServiceList=new ArrayList<>();
			for(int i=0;i<passenger;i++)
			{
				
				Passenger p = new Passenger();
				SpecialService s=new SpecialService();
				String salutation = request.getParameter("salutation"+(i+1));
				String firstName = request.getParameter("firstname"+(i+1));
				String lastName = request.getParameter("lastname"+(i+1));
				String passengerType = request.getParameter("passengertype"+(i+1));
				
				String seatType1=request.getParameter("seattype1"+(i+1));
				String seatType2=request.getParameter("seattype2"+(i+1));
				String meal=request.getParameter("meal"+(i+1));
				String handicapped=request.getParameter("medical"+(i+1));
				
				System.out.println(salutation);
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(passengerType);
				System.out.println(seatType1);
				System.out.println(seatType2);
				System.out.println(meal);
				System.out.println(handicapped);
				p.setFirstName(firstName);
				p.setLastName(lastName);
				p.setSalutation(salutation);
				p.setPassengerType(passengerType);
				s.setSeatType1(seatType1);
				s.setSeatType2(seatType2);
				s.setMealType(meal);
				s.setHandicapped(handicapped);
				p.setSpecialService(s);
				list.add(p);
				System.out.println("Added to list");
				
			}
			
			for(Passenger p:list) {
				System.out.println(p.getFirstName());
				System.out.println(p.getLastName());
				System.out.println(p.getSpecialService().getMealType());
				
			}
			
			
			//User user = (User) session.getAttribute("user");

			System.out.println(ticket.getStatus());
			ticket.setPassengerList(list);
			
			session.setAttribute("ticketwithpassenger", ticket);
			//ticket.setUser(user);
			}
			System.out.println(ticket.getUser().getEmailId());
			
			/*TicketBo ticketBO = new TicketBo();
			boolean status = ticketBO.createTicket(ticket);
			System.out.println(status);
			System.out.println("After Booked");*/
			dispatch = request.getRequestDispatcher("visa.jsp");
			dispatch.forward(request, response);
			
			
		}
		
		
	}
