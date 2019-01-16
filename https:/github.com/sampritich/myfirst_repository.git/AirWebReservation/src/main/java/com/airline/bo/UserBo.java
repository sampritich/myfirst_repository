package com.airline.bo;

import com.airline.dao.LoginDao;
import com.airline.model.User;

public class UserBo {
	LoginDao logindao=new LoginDao();

	
	public boolean validate(User user) {
		
		
		boolean status=logindao.validate(user);
		
		if(status) {
			System.out.println(status+"in bo");
		}
		else {
			System.out.println(status+"in bo");

		}
		return status;
	}
	
	public boolean register(User user) {
		
		boolean status=logindao.create(user);
		if(status) {
			System.out.println(status+"bo");
		}
		else {
			System.out.println(status+"bo");
		}
		return status;
	}

}
