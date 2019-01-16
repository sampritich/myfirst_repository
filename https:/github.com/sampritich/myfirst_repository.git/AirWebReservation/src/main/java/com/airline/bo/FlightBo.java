package com.airline.bo;

import com.airline.dao.FlightRecordsDao;
import com.airline.model.*;
import java.util.*;
public class FlightBo {
	
	//List<FlightDetails> list=new ArrayList<>();
	
	public List<Flight>  flightRecords(Flight flightdetails){
		
		
		FlightRecordsDao flightdao=new FlightRecordsDao();
		
	List<Flight> list=flightdao.records(flightdetails);
	
		
		return list;
		
	}

}
