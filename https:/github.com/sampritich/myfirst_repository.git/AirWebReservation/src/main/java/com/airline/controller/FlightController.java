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
import com.airline.model.Flight;

/**
 * Servlet implementation class FlightController
 */
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session=request.getSession(false);
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


