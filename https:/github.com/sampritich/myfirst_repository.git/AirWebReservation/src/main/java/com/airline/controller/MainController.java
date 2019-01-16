package com.airline.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.bo.FlightBo;
import com.airline.bo.UserBo;
import com.airline.dao.LoginDao;
import com.airline.model.Flight;
import com.airline.model.User;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatch = null;
		
		
		
		UserBo loginbo=new UserBo();
		
		
		
		LoginDao mySqlDAO=new LoginDao();
		
		
		String button=request.getParameter("button");
		
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("phoneno");
		
		 System.out.println(emailId);
			System.out.println(password);
			System.out.println(contact);
			User user = new User();
			 user.setEmailId(emailId);
				user.setPassword(password);
				user.setContact(contact);
			 
				System.out.println(user.getEmailId()+"user");
				System.out.println(user.getPassword()+"user");
				System.out.println(user.getContact()+"user");
		
		System.out.println(button);
		
		if("Login".equals(button))
		{
			String loginemail=request.getParameter("email");
			String loginpassword=request.getParameter("password");
			System.out.println(loginemail);
			System.out.println(loginpassword);
			System.out.println(button);
			User user1=new User();
			
			user1.setEmailId(loginemail);
			user1.setPassword(loginpassword);
			System.out.println("Inside Login");
			boolean status = loginbo.validate(user1);
			System.out.println(status);
			//HttpSession loginsession=request.getSession();
			if(status)
			{
				session.setAttribute("loginuser", user1);

				System.out.println(user1.getContact()+"Main");
				
				dispatch = request.getRequestDispatcher("Profile.jsp");
				//session.setAttribute("user", user);
				dispatch.forward(request, response);
			}
			
			
			
		}
			
			else  if("signup".equals(button))
		{
				UserBo userbo=new UserBo();
				
						
				System.out.println("Inside Signup");
			boolean statuscreate = userbo.register(user);
			//System.out.println(status);
			if(statuscreate)
			{
				dispatch = request.getRequestDispatcher("SuccessReg.jsp");
				//session.setAttribute("user", user);
				dispatch.forward(request, response);
			}
			
		}
		
	
		
		
			else {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String departure=request.getParameter("source");
		
		String arrival=request.getParameter("destination");
		
		String date=request.getParameter("date");
		
		int passenger=Integer.parseInt(request.getParameter("passenger"));
		
		//HttpSession passengercount=request.getSession();
		session.setAttribute("passenger",passenger);
		
		if(date.isEmpty()) {
			Date date1=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			date=sdf.format(date1);
			System.out.println(date);
		}
		
		System.out.println(departure);
		
		System.out.println(arrival);
		
		System.out.println(date);
		
		System.out.println(passenger);
		
		Flight flightdetails=new Flight();
		
		flightdetails.setDeparture(departure);
		flightdetails.setArrival(arrival);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date d=null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flightdetails.setDate(d);
		
		FlightBo flightbo=new FlightBo();
		
		List<Flight> list=new ArrayList<>();
		
		list=flightbo.flightRecords(flightdetails);
		
		for(Flight f:list) {
			System.out.println(f.getArilineName());
			System.out.println(f.getArrival());
			//System.out.println(f.getBusinessPrice());
		}
		
		//HttpSession session2=request.getSession();
		session.setAttribute("flightlist", list);
		RequestDispatcher dispatcher=null;
		if(list.size()==0) {
			
		}
		else {
			dispatcher=request.getRequestDispatcher("Example.jsp");
			dispatcher.forward(request, response);
		}
		
		
			}

}
}
