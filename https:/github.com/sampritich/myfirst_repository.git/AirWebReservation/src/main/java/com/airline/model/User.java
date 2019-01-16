package com.airline.model;

import javax.persistence.*;

@Entity
@Table
public class User {

	
	@Id
	private String emailId;
	@Column(nullable = false)
	private String contact;
	@Column(nullable = false)
	private String password;
	
	
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
