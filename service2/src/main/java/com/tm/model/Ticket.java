package com.tm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {
	// database variables of the form "ticket_id"
	@Id
	@GeneratedValue
	private Long ticketId;	// cannot be null
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Long flightId;	// these i a real database will be values that are unique together
	private Long seatId;	//
	
	public Ticket() {	// for JPA
	}
	public Ticket(String firstName, String lastName, String phone, String email, Long flightId, Long seatId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.flightId = flightId;
		this.seatId = seatId;
	}
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", flightId=" + flightId + ", seatId=" + seatId + "]";
	}
}
