package com.airline.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight {
	
	@Id
private String flightId;
@Column
private String airlineName;
@Column
private String departure;
@Column

private String arrival;
@Column
private Date date;

@Column

private Time departureTime;
@Column
private Time arrivalTime;
@Column
private float duration;
@Column
private int businessSeat;
@Column
private int economySeat;
@Column
private float businessPrice;
@Column
private float economyPrice;





public Flight() {
	super();
}

public Flight(String flightId, String arilineName, String departure, String arrival, Date date,
		Date departureTime, Date arrivalTime, float duration, int businessSeat, int economySeat, float businessPrice,
		float economyPrice) {
	super();
	this.flightId = flightId;
	this.airlineName = arilineName;
	this.departure = departure;
	this.arrival = arrival;
	this.date = date;
	this.departureTime = (Time) departureTime;
	this.arrivalTime = (Time) arrivalTime;
	this.duration = duration;
	this.businessSeat = businessSeat;
	this.economySeat = economySeat;
	this.businessPrice = businessPrice;
	this.economyPrice = economyPrice;
}

public String getFlightId() {
	return flightId;
}

public void setFlightId(String flightId) {
	this.flightId = flightId;
}

public String getArilineName() {
	return airlineName;
}

public void setArilineName(String arilineName) {
	this.airlineName = arilineName;
}

public String getDeparture() {
	return departure;
}

public void setDeparture(String departure) {
	this.departure = departure;
}

public String getArrival() {
	return arrival;
}

public void setArrival(String arrival) {
	this.arrival = arrival;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Date getDepartureTime() {
	return departureTime;
}

public void setDepartureTime(Time departureTime) {
	this.departureTime =  departureTime;
}

public Date getArrivalTime() {
	return arrivalTime;
}

public void setArrivalTime(Time arrivalTime) {
	this.arrivalTime = arrivalTime;
}

public float getDuration() {
	return duration;
}

public void setDuration(float duration) {
	this.duration = duration;
}

public int getBusinessSeat() {
	return businessSeat;
}

public void setBusinessSeat(int businessSeat) {
	this.businessSeat = businessSeat;
}

public int getEconomySeat() {
	return economySeat;
}

public void setEconomySeat(int economySeat) {
	this.economySeat = economySeat;
}

public float getBusinessPrice() {
	return businessPrice;
}

public void setBusinessPrice(float businessPrice) {
	this.businessPrice = businessPrice;
}

public float getEconomyPrice() {
	return economyPrice;
}

public void setEconomyPrice(float economyPrice) {
	this.economyPrice = economyPrice;
}







}