package com.cg.ts.dao;

import com.cg.ts.exceptions.TSException;

import com.cg.ts.model.BookingBean;

public interface TruckDao {

	boolean verifyavaliability(int truckid) throws TSException;

	int insertbookingdetails(BookingBean bookingdetails) throws TSException;

}
