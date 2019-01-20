package com.cg.ts.service;

import com.cg.ts.exceptions.TSException;
import com.cg.ts.model.BookingBean;

public interface Truckservice {

	boolean validateFields(BookingBean bookingdetails) throws TSException;

	int addbookingdetails(BookingBean bookingdetails) throws TSException;

}
