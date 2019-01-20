package com.cg.ts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.ts.dao.TruckDao;
import com.cg.ts.dao.TruckDaoImpl;
import com.cg.ts.exceptions.TSException;
import com.cg.ts.model.BookingBean;
import com.cg.ts.model.TruckBean;

public class truckserviceimpl implements Truckservice {
	
	List<String> list = new ArrayList<>();
	TruckDao truckdao = new TruckDaoImpl();
	TruckBean truckdetails=new TruckBean();
	

	@Override
	public boolean validateFields(BookingBean bookingdetails) throws TSException {
		
		boolean validateflag=false;
		if(!checkcustomerid(bookingdetails.getCustid()))
		{
			list.add("The customerId should contain One Capital letter followed by 6 digits ");
		}
		if(!checkmobileno(bookingdetails.getCustmobile()))
		{
			list.add("Should contain 10 numbers and can start with 6|7|8|9 ");
		}
		if(truckdao.verifyavaliability(truckdetails.getTruckid()))
		{
			list.add("The truck id doesn't exits ");
		}
		if(list.size()>0)
		{
			System.out.println(list);
		}
		else
		{
			validateflag=true;
		
		}
		return validateflag;
	}

	private boolean checkcustomerid(String custid) {
		String custidregx="[A-Z]{1}[0-9]{6}$";
		return Pattern.matches(custidregx, custid);
	}

	private boolean checkmobileno(long custmobile) {
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(custmobile));
			
	}
	
	
	@Override
	public int addbookingdetails(BookingBean bookingdetails) throws TSException {
		
		return truckdao.insertbookingdetails(bookingdetails);
	}

}
