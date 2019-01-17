package com.cg.ma.dao;

import java.util.List;

import com.cg.ma.exceptions.MAException;
import com.cg.ma.model.CustomerMobileDetails;

public interface MobileDao {

	int insertrecords(CustomerMobileDetails mobiledetails) throws MAException;

	boolean verifyquantity(int mobileid)throws MAException;

	List<CustomerMobileDetails> viewmobilequantity() throws MAException;

	List<CustomerMobileDetails> getpricedetails(Double mobileprice, Double upperRange)throws MAException;

	int getdeletedetails(int Mobileid) throws MAException;

}
