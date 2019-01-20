package com.cg.ts.model;

import java.time.LocalDateTime;

public class BookingBean {
	private int bookingid;
	private String custid;
	private long custmobile;
	private int nooftrucks;
	private LocalDateTime dateoftansport;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public long getCustmobile() {
		return custmobile;
	}
	public void setCustmobile(long custmobile) {
		this.custmobile = custmobile;
	}
	public int getNooftrucks() {
		return nooftrucks;
	}
	public void setNooftrucks(int nooftrucks) {
		this.nooftrucks = nooftrucks;
	}
	public LocalDateTime getDateoftansport() {
		return dateoftansport;
	}
	public void setDateoftansport(LocalDateTime dateTime) {
		this.dateoftansport = dateTime;
	}
	public BookingBean(int bookingid, String custid, long custmobile, int nooftrucks, LocalDateTime dateoftansport) {
		super();
		this.bookingid = bookingid;
		this.custid = custid;
		this.custmobile = custmobile;
		this.nooftrucks = nooftrucks;
		this.dateoftansport = dateoftansport;
	}
	public BookingBean() {
		
	}

}
