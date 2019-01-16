package com.airline.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.airline.model.Flight;
import com.airline.util.HibernateUtil;

public class FlightRecordsDao implements FlightDao{

	private SessionFactory sessionfactory;
	
	
	public FlightRecordsDao() {
		sessionfactory=HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<Flight> records(Flight flight) {
		
		Session session=sessionfactory.openSession();
		
		
		String departure=flight.getDeparture();
		String arrival=flight.getArrival();
		Date date=flight.getDate();
		
		System.out.println(departure+"dao");
System.out.println(date+"dao");
		
		System.out.println(arrival+"dao");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		String sql = "select * from Flight WHERE departure=\"KOLKATA\"";
		String hql = "from Flight f where f.departure=:dept and f.arrival=:arrival and f.date=:date";
		Query query = session.createQuery(hql);
		//SQLQuery query = session.createSQLQuery(sql);
		session.beginTransaction();
		//query.addEntity(FlightDetails.class);
				query.setParameter("dept",departure);
				query.setParameter("arrival", arrival);
				query.setParameter("date", date);


				//query.setParameter("arrival", arrival);
				List<Flight> flightrecord=query.list();
		
				for(Flight f:flightrecord) {
					System.out.println(f.getArilineName());
					System.out.println(f.getArrival());
					//System.out.println(f.getBusinessPrice());
				}
		if(flightrecord.size()==0) {
		System.out.println("list is empty");	
		}
		else {
			System.out.println("list is full");
		}
		session.getTransaction().commit();
        session.close();
		return flightrecord;
	}
	
	
	

	
}
