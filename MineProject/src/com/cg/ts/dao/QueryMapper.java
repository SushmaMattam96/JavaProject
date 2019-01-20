package com.cg.ts.dao;

public interface QueryMapper {

	String getinsertrecord = "INSERT INTO  bookingdetail VALUES(booking_id_seq.nextval,?,?,?,?,sysdate)";
	String updateQuantity = "UPDATE truckdetails SET AVALIABLENOS=AVALIABLENOS-1 WHERE truckid=?";

}
