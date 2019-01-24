package com.capgemini.truckbooking.service;

import java.util.List;

import com.capgemini.truckbooking.Exception.TSException;
import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;

public interface ITruckService {
	List<TruckBean> retrieveTruckDetails() throws TSException;
	
	int bookTrucks(BookingBean bookingbean) throws TSException;

	boolean validateFields(BookingBean bookingdetails) throws TSException;

	

}
