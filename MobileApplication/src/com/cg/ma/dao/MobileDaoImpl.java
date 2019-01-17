package com.cg.ma.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.ma.exceptions.MAException;
import com.cg.ma.model.CustomerMobileDetails;
import com.cg.ma.utility.JdbcUtility;

public class MobileDaoImpl implements MobileDao {
	Connection connection=null;
	PreparedStatement preparestatement=null;
	ResultSet resultset=null;
	private CustomerMobileDetails mobiledetails;
	@Override
	public int insertrecords(CustomerMobileDetails mobiledetails) throws MAException {
		connection = JdbcUtility.getConnection();
		int result=0;
		try {
			preparestatement=connection.prepareStatement(QueryMapper.getinsertrecord);
			preparestatement.setString(1, mobiledetails.getCustomerName());
			preparestatement.setString(2, mobiledetails.getMailid());
			preparestatement.setString(3,mobiledetails.getPhoneNo());
			preparestatement.setInt(4, mobiledetails.getMobileid());
			result=preparestatement.executeUpdate();
			
			preparestatement=connection.prepareStatement(QueryMapper.updateQuantity);
			preparestatement.setInt(1, mobiledetails.getMobileid());
			preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new MAException("Prepared statement is not created"); 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new MAException("Connection not closed");
			} 
			try {
				preparestatement.close();
			} catch (SQLException e) {
				throw new MAException("statment not closed");
			}
		}
		
		return result;
	}
	@Override
	public boolean verifyquantity(int mobileid) throws MAException {
		
		connection = JdbcUtility.getConnection();
		try {
			preparestatement=connection.prepareStatement(QueryMapper.selectQuantity);
			/*System.out.println(mobiledetails.getMobileid());*/
			preparestatement.setInt(1, mobileid);
			resultset= preparestatement.executeQuery();
		} catch (SQLException e) {
			throw new MAException("Connection is not closed");
		}
		
		return false;
	}
	@Override
	public List<CustomerMobileDetails> viewmobilequantity() throws MAException {
		connection=JdbcUtility.getConnection();
		List<CustomerMobileDetails> list=new ArrayList<CustomerMobileDetails>();
		try{
			preparestatement=connection.prepareStatement(QueryMapper.viewQuantity);
			resultset=preparestatement.executeQuery();
			
			while(resultset.next())
				{
				int id=resultset.getInt(1);
				String mobilename=resultset.getString(2);
				Double mobileprice=resultset.getDouble(3);
				int quantity=resultset.getInt(4);
				CustomerMobileDetails mobiledetails=new CustomerMobileDetails();
				mobiledetails.setMobileid(id);
				mobiledetails.setMobileName(mobilename);
				mobiledetails.setPrice(mobileprice);
				mobiledetails.setQuantity(quantity);
				list.add(mobiledetails);
				}
			
		}catch(SQLException e){
			throw new MAException("Connection is not closed");	
		}
		return list;
	}
	@Override
	public List<CustomerMobileDetails> getpricedetails(Double lowerrange, Double upperRange) throws MAException {
		connection=JdbcUtility.getConnection();
		List<CustomerMobileDetails> list1=new ArrayList<CustomerMobileDetails>();
		try {
			
			preparestatement=connection.prepareStatement(QueryMapper.mobileprice);
			/*System.out.println(lowerrange + "     " + upperRange);*/
			preparestatement.setDouble(1, lowerrange);
			preparestatement.setDouble(2, upperRange);
			resultset=preparestatement.executeQuery();
		
			while(resultset.next())
			{
			String name=resultset.getString(1);
			CustomerMobileDetails mobiledetails=new CustomerMobileDetails();
			mobiledetails.setMobileName(name);
			list1.add(mobiledetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public int getdeletedetails(int Mobileid) throws MAException {
		connection=JdbcUtility.getConnection();
		int result=0;
		try {
			preparestatement=connection.prepareStatement(QueryMapper.deletemobiles);
			preparestatement.setInt(1,Mobileid);
			result=preparestatement.executeUpdate();
		} catch (SQLException e) {
			throw new MAException("Connection is not closed");
		}
		
		return result;
	}

}
