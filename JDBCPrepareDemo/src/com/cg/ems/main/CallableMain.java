package com.cg.ems.main;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.cg.ems.exception.EMSException;
import com.cg.ems.utility.JDBCUtility;

public class CallableMain {
	public static void main(String args[]) throws EMSException
	{
		CallableStatement callablestatement=null;
		try{
		
		Connection connection=JDBCUtility.getConnection();
		String query="{call jee_jdbcdemo_proc(?,?,?)}";
		
		connection.setAutoCommit(false);
		callablestatement=connection.prepareCall(query);
		callablestatement.setString(1, "Nihal");
		callablestatement.setDouble(2,56943.45);
		callablestatement.setString(3,"Hyderabad");
		int result=callablestatement.executeUpdate();
		System.out.println(result+ "   inserted");
		connection.commit();
		}catch(SQLException e){
			
		}
		
	}

}
