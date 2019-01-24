package com.capgemini.truckbooking.dao;

import java.util.List;

import com.capgemini.truckbooking.Exception.TSException;
import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;

public interface ITruckDao {

	List<TruckBean> retriveTruckDetails() throws TSException;

	boolean verifyavaliability(int truckid) throws TSException;

	int bookTrucks(BookingBean bookingbean) throws  TSException;

}
