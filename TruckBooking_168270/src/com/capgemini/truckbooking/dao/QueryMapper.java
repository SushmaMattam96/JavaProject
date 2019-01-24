package com.capgemini.truckbooking.dao;

public interface QueryMapper {

	String viewtruckdetails = "SELECT * FROM TruckDetails";
	String inserttruckbooking = "INSERT INTO BookingDetails VALUES( booking_id_seq.nextval,?,?,?,?,?)";
	String updateAvailtrucks = "UPDATE truckdetails SET  availableNos= availableNos-1 WHERE truckid=?";

}
