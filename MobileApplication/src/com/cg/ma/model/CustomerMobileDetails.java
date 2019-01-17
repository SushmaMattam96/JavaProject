package com.cg.ma.model;

public class CustomerMobileDetails{
	private int mobileid;
	private String customerName;
	private String mobileName;
	private Double price;
	private int quantity;
	private String mailid;
	private String phoneNo;
	
	
public CustomerMobileDetails(){
		
	}
	
	public CustomerMobileDetails(int mobileid, String customerName,
			String mobileName, Double price, int quantity, String mailid,
			String phoneNo) {
		super();
		this.mobileid = mobileid;
		this.customerName = customerName;
		this.mobileName = mobileName;
		this.price = price;
		this.quantity = quantity;
		this.mailid = mailid;
		this.phoneNo = phoneNo;
	}


	public int getMobileid() {
		return mobileid;
	}


	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getMobileName() {
		return mobileName;
	}


	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getMailid() {
		return mailid;
	}


	public void setMailid(String mailid) {
		this.mailid = mailid;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	
	
}