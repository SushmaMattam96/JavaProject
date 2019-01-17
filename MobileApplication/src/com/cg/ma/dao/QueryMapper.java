package com.cg.ma.dao;

public interface QueryMapper {

	String getinsertrecord = "INSERT INTO  PurchaseDetails VALUES(mobile_seq.nextval,?,?,?,sysdate,?)";
	String updateQuantity = "UPDATE Mobiles SET QUATITY=QUATITY-1 WHERE Mobileid=?";
	String selectQuantity = "SELECT QUATITY FROM Mobiles WHERE Mobileid=?";
	String viewQuantity = "SELECT * FROM Mobiles";
	String mobileprice = "SELECT NAME FROM Mobiles WHERE PRICE BETWEEN ? and ?";

}
