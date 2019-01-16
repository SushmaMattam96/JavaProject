package com.cg.ems.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.ems.exception.EMSException;

public class JDBCUtility {
	private static Connection connection=null;
	public static Connection getConnection() throws EMSException {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e)
		{
			throw new EMSException("Class not loaded");
		}
		try{
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","corp123");
		} catch(SQLException e){
			throw new EMSException("not connected to database");
		}
		return connection;
		
	}

}
