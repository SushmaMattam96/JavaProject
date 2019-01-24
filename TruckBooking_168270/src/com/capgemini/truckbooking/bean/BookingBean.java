package com.capgemini.truckbooking.bean;

import java.time.LocalDateTime;

public class BookingBean {
	private int bookingId;
	private String custid;
	private long custMobile;
	private int truckid;
	private int noOfTrucks;
	private LocalDateTime dateofTransport;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public long getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	public int getTruckid() {
		return truckid;
	}
	public void setTruckid(int truckid) {
		this.truckid = truckid;
	}
	public int getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(int noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public LocalDateTime getDateofTransport() {
		return dateofTransport;
	}
	public void setDateofTransport(LocalDateTime dateofTransport) {
		this.dateofTransport = dateofTransport;
	}
	public BookingBean(int bookingId, String custid, long custMobile,
			int truckid, int noOfTrucks, LocalDateTime dateofTransport) {
		super();
		this.bookingId = bookingId;
		this.custid = custid;
		this.custMobile = custMobile;
		this.truckid = truckid;
		this.noOfTrucks = noOfTrucks;
		this.dateofTransport = dateofTransport;
	}
	public BookingBean(){
		
	}
}
