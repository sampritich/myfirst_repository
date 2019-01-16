package com.airline.bo;

import com.airline.dao.TicketDetailsDao;
import com.airline.model.Ticket;

public class TicketBo {

	
	public boolean createTicket(Ticket ticket) {
		
		
		TicketDetailsDao tdao=new TicketDetailsDao();
		
		boolean status=tdao.createTicket(ticket);
		
		if(status) {
			System.out.println(status+"bo");
		}
		else {
			System.out.println(status+"bo");
		}
		return status;
	}
	
}
