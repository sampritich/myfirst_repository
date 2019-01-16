package com.airline.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class VisaInformation {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int visaId;
	@Column	
private	String country;
	@Column
private String visaIdentityNumber;
	@Column
private Date dateOfIssue;
	@Column
private Date dateOfExpiry;
	public VisaInformation(int visaId, String country, String visaIdentityNumber, Date dateOfIssue, Date dateOfExpiry) {
		super();
		this.visaId = visaId;
		this.country = country;
		this.visaIdentityNumber = visaIdentityNumber;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
	}
	public VisaInformation() {
		super();
	}
	public int getVisaId() {
		return visaId;
	}
	public void setVisaId(int visaId) {
		this.visaId = visaId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVisaIdentityNumber() {
		return visaIdentityNumber;
	}
	public void setVisaIdentityNumber(String visaIdentityNumber) {
		this.visaIdentityNumber = visaIdentityNumber;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	
	
	

}
