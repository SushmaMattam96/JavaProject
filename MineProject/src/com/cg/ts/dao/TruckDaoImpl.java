package com.cg.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cg.ts.exceptions.TSException;
import com.cg.ts.model.BookingBean;
import com.cg.ts.model.TruckBean;
import com.cg.ts.utility.JdbcUtility;

public class TruckDaoImpl implements TruckDao {
	Connection connection=null;
	PreparedStatement preparestatement=null;
	ResultSet resultset=null;
	TruckBean truckbean= new TruckBean();
	@Override
	public boolean verifyavaliability(int truckid) throws TSException{
		
		
		return false;
	}

	@Override
	public int insertbookingdetails(BookingBean bookingdetails) throws TSException {
		
		
			connection = JdbcUtility.getConnection();
				int result=0;
		try {
			preparestatement=connection.prepareStatement(QueryMapper.getinsertrecord);
			preparestatement.setString(1,bookingdetails.getCustid());
			preparestatement.setInt(2,truckbean.getTruckid());
			preparestatement.setInt(3,bookingdetails.getNooftrucks());
			preparestatement.setLong(4,bookingdetails.getCustmobile());
			result=preparestatement.executeUpdate();
			
			preparestatement=connection.prepareStatement(QueryMapper.updateQuantity);
			preparestatement.setInt(1,truckbean.getTruckid());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new TSException("Prepared statement is not created"); 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new TSException("Connection not closed");
			} 
			try {
				preparestatement.close();
			} catch (SQLException e) {
				throw new TSException("statment not closed");
			}
		}
		
		return result;
	}

}
