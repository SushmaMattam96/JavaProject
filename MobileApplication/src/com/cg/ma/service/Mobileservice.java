package com.cg.ma.service;

import java.util.List;

import com.cg.ma.exceptions.MAException;
import com.cg.ma.model.CustomerMobileDetails;

public interface Mobileservice {

	boolean validateFields(CustomerMobileDetails mobiledetails)throws MAException;

	int addpurchasedetails(CustomerMobileDetails mobiledetails)throws MAException ;

	List<CustomerMobileDetails> getpricedetails(Double mobileprice, Double upperRange)throws MAException;

}
