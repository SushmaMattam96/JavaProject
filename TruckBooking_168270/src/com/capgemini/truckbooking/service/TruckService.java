package com.capgemini.truckbooking.service;

import java.util.ArrayList;


import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.truckbooking.Exception.TSException;
import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.dao.ITruckDao;
import com.capgemini.truckbooking.dao.TruckDao;

public class TruckService implements ITruckService {
	
	ITruckDao truckdao=new TruckDao();

	@Override
	public List<TruckBean> retrieveTruckDetails() throws TSException {
		
		return truckdao.retriveTruckDetails() ;
	}

	@Override
	public boolean validateFields(BookingBean bookingdetails)
			throws TSException {
		BookingBean truckdetails= new BookingBean();
		boolean validateflag=false;
		List<String> list = new ArrayList<String>();
		if(!checkcustomerid(bookingdetails.getCustid()))
		{
			list.add("The customerId should contain One Capital letter followed by 6 digits ");
		}
		if(!checkmobileno(bookingdetails.getCustMobile()))
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
		else{
			return validateflag=true;
		}
		return validateflag;
	}

	private boolean checkmobileno(long custMobile) {
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(custMobile));
	}

	private boolean checkcustomerid(String custid) {
		String custidRegEx="[A-Z]{1}[0-9]{6}$";
		return Pattern.matches(custidRegEx,custid);
	}

	@Override
	public int bookTrucks(BookingBean bookingbean) throws TSException {
		
		return truckdao.bookTrucks(bookingbean);
	}
}
