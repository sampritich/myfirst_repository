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

import com.airline.bo.BookingCheck;
import com.airline.bo.TicketBo;
import com.airline.bo.UserBo;
import com.airline.dao.TicketDetailsDao;
import com.airline.model.Flight;
import com.airline.model.Ticket;
import com.airline.model.User;

/**
 * Servlet implementation class FlightDetailsController
 */
public class FlightDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	Ticket ticket=new Ticket();
    	
    	
    	
    	TicketBo ticketBO=new TicketBo();
    	
    	BookingCheck bookingCheck=new BookingCheck();
    	
    	
    	if ("signup".equals(request.getParameter("signup"))) {
			User user = new User();
			UserBo userBO = new UserBo();

			String emailId = request.getParameter("email");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			user.setEmailId(emailId);
			user.setPassword(password);
			user.setContact(contact);
			System.out.println("New Signup");
			boolean status = userBO.register(user);
			System.out.println(status);
		}
    	else {
    	Flight flight=new Flight();

    	
    	String button = null;
		String booked = request.getParameter("Booked");
		String reserve = request.getParameter("Reserve");
		String preBook = request.getParameter("PreBook");
		
		
		if(booked!=null)
		{
			button=booked+"booked";
		}
		else if(reserve!=null)
		{
			button=reserve+"Reserve";
		}
		else if(preBook!=null)
		{
			button=preBook+"Prebook";
		}
    	String airlinename = request.getParameter("airlinename");
		
		String flightid= request.getParameter("flightid");
		
		String departure=request.getParameter("source");
		String arrival=request.getParameter("destination");
		String Date=request.getParameter("date");
		String departuretime=request.getParameter("departuretime");
		String arrivaltime=request.getParameter("arrivaltime");
		
		String duration=request.getParameter("duration");
		String businessseat=request.getParameter("businessseat");
		String businessPrice=request.getParameter("businessprice");
		
		String economyseat=request.getParameter("economyseat");
		
		String economyPrice=request.getParameter("economyprice");
		
		
		
		
		
		
		
		
		System.out.println(airlinename);
		System.out.println(flightid);
		System.out.println(economyPrice);
		System.out.println(businessPrice);
		System.out.println(Date);
		
		
		System.out.println(departuretime);
		
		

         

       flight.setArilineName(airlinename);

         flight.setArrival(arrival);
         
         SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
         
         
		Date d = null;
		try {
			d = new SimpleDateFormat("HH:mm:ss").parse(arrivaltime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Time sqlTime = new java.sql.Time(d.getTime());

		flight.setArrivalTime(sqlTime);
		
		
         
         flight.setBusinessPrice(Float.parseFloat(businessPrice));

         flight.setBusinessSeat(Integer.parseInt(businessseat));
         
         
         
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         
         Date date1=null;
		try {
			date1 = sdf.parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
         flight.setDate(date1);
         

         flight.setDeparture(departure);

         //SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
         Date departureT=null;
		try {
			departureT = new SimpleDateFormat("HH:mm:ss").parse(departuretime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.sql.Time sqldTime = new java.sql.Time(departureT.getTime());
         flight.setDepartureTime(sqldTime);

         flight.setDuration(Float.parseFloat(duration));

         flight.setEconomyPrice(Float.parseFloat(economyPrice));

         flight.setEconomySeat(Integer.parseInt(economyseat));

         flight.setFlightId(flightid);

        
         HttpSession session=request.getSession();
       System.out.println(flight.getArrivalTime()+"flight arrival");

         User user=new User();
         
         RequestDispatcher dispatch =null;

         user=(User)session.getAttribute("loginuser");
         if(user!=null) {

         System.out.println(user.getContact()+"flightdetails");
     	int passengercount=(Integer)session.getAttribute("passenger");
     	ticket.setFlight(flight);
   	    ticket.setPassengerCount(passengercount);
   	    ticket.setStatus(button);
   	     ticket.setUser(user);

   	     session.setAttribute("ticket", ticket);
   	     
   	     
   	  if (reserve!=null) {

			boolean status = bookingCheck.validateBookingReserve(date1);

			System.out.println("to block ");

			if (status) {

				boolean bookingStatus=ticketBO.createTicket(ticket);

	        	 

	        	 if(bookingStatus) {

	        		 System.out.println("successfully update");

	        	 }

	        	 else {

	        		 System.out.println("not updated");

	        	 }
				//System.out.println("allowed");

			}

			else {

				System.out.println("not allow");

			}

		}

		else if (preBook!=null) {

			System.out.println("to prebook");

			boolean status = bookingCheck.validatePrebooking(date1);

			if (status) {

				boolean bookingStatus=ticketBO.createTicket(ticket);

	        	 

	        	 if(bookingStatus) {

	        		 System.out.println("successfully update");

	        	 }

	        	 else {

	        		 System.out.println("not updated");

	        	 }

			}

			else {

				System.out.println(" not allowed+controller");

			}

		}
		else if(booked!=null)
		{
			
			
			
			boolean status  = bookingCheck.concessionCheck(date1);
			if(status)
			{
				float newPrice = 0 ;
				
				if("Economy".equals(booked))
				{
					//System.out.println("Economy");
					
					newPrice = bookingCheck.giveConcession(Float.parseFloat(economyPrice));
					System.out.println(newPrice);
					
				}
				else if("Business".equals(booked))
				{
					//System.out.println("Business");
					
					newPrice = bookingCheck.giveConcession(Float.parseFloat(businessPrice));
					System.out.println(newPrice);
				}
				
				session.setAttribute("price", newPrice);
			}
			else
			{
				float oldPrice = 0 ;
						
				if("Economy".equals(booked))
				{
					//System.out.println("Economy");
					
					oldPrice = Float.parseFloat(economyPrice);
					System.out.println(oldPrice);
					
				}						
				else if("Business".equals(booked))
				{
					//System.out.println("Business");
					
					oldPrice = Float.parseFloat(businessPrice);
					System.out.println(oldPrice);
					
				}
				session.setAttribute("price", oldPrice);
			}
			
			session.setAttribute("ticket", ticket);
			RequestDispatcher dispatcher=null;
			dispatcher=request.getRequestDispatcher("Passengers.jsp");
			dispatcher.forward(request, response);
			
		}

	}

	else if (user == null) {

		System.out.println("non user");

		dispatch = request.getRequestDispatcher("signup.jsp");
		dispatch.forward(request, response);

	}
}

}

}
