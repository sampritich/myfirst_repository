package com.airline.dao;

import com.airline.model.User;

public interface DAO {
	
	public boolean validate(User user);
	
	public boolean create(User user);

}
