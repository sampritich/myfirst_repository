package com.airline.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.airline.model.User;
import com.airline.util.HibernateUtil;
public class LoginDao implements DAO{

	
	private SessionFactory sessionfactory;
	
	
	
	public LoginDao() {
		sessionfactory=HibernateUtil.getSessionFactory();
	}



public boolean validate(User user) {
		
		Session session = sessionfactory.openSession();
		String hql = "from User where emailId = ?1 and password = ?2";
		
		User u= (User)session.createQuery(hql)
				.setParameter(1, user.getEmailId()).setParameter(2, user.getPassword()).uniqueResult();
		
		boolean status=false;
		System.out.println(u.getContact());
		System.out.println(u.getEmailId());
		if(u!=null) {
			user.setContact(u.getContact());
			System.out.println(u.getContact()+"under");
			System.out.println(u.getEmailId()+"under");
			System.out.println(u.getContact()+"under");
			status=true;
			System.out.println(status);
			
		}
		return status;
	}
	
	public boolean create(User user) {
		// TODO Auto-generated method stub
		
		Session session = sessionfactory.openSession();
        session.beginTransaction();
 
        try{
        	session.saveOrUpdate(user);
        	 session.getTransaction().commit();
             session.close();
             return true;
        }
        
        catch(HibernateException ex)
        {
        	return false;
        }

		
}
}
