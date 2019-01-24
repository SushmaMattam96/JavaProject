package com.capgemini.truckbooking.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.truckbooking.Exception.TSException;
import com.capgemini.truckbooking.Utility.JdbcUtility;
import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;





public class TruckDao implements ITruckDao {
	/* Logger logger = Logger.getLogger(MobileDaoImpl.class); */
	Connection connection = null;
	PreparedStatement preparestatement = null;
	ResultSet resultset = null;
	BookingBean bookingdetails=null;
	
	List<TruckBean> truckbeanlist = new ArrayList<TruckBean>();
	@Override
	public List<TruckBean> retriveTruckDetails() throws TSException {
		connection = JdbcUtility.getConnection();
		
		try {
			preparestatement = connection
					.prepareStatement(QueryMapper.viewtruckdetails);
			
			resultset = preparestatement.executeQuery();
			while (resultset.next()) {
				int truckid = resultset.getInt(1);
				String trucktype = resultset.getString(2);
				String origin = resultset.getString(3);
				String destination = resultset.getString(4);
				Float charges = resultset.getFloat(5);
				int availno = resultset.getInt(6);
				TruckBean truckdetails = new TruckBean();
				truckdetails.setTruckId(truckid);
				truckdetails.setTruckType(trucktype);
				truckdetails.setOrigin(origin);
				truckdetails.setDestination(destination);
				truckdetails.setCharges(charges);
				truckdetails.setAvailableNos(availno);
				truckbeanlist.add(truckdetails);
			}
		} catch (SQLException e) {
			System.out.println("Connection is not closed");
		}
		return truckbeanlist;
	}

	@Override
	public boolean verifyavaliability(int truckid) throws TSException {
		connection = JdbcUtility.getConnection();
		try {
			preparestatement = connection
					.prepareStatement(QueryMapper.updateAvailtrucks);
			preparestatement.setInt(1, truckid);
			resultset = preparestatement.executeQuery();
		} catch (SQLException e) {
			throw new TSException("Connection is not closed");
		}

		

		return false;
	}

	@Override
	public int bookTrucks(BookingBean bookingbean) throws TSException {
		connection = JdbcUtility.getConnection();
		TruckBean truckbean=new TruckBean();
		int result=0;
		try{
			preparestatement=connection.prepareStatement(QueryMapper.inserttruckbooking);
			while(result>0)
			{
			preparestatement.setString(1,bookingdetails.getCustid());
			System.out.println("dfgvf");
			preparestatement.setInt(2,bookingdetails.getTruckid());
			preparestatement.setInt(3,bookingdetails.getNoOfTrucks());
			preparestatement.setLong(4,bookingdetails.getCustMobile());
			
			result=preparestatement.executeUpdate();
			
			preparestatement=connection.prepareStatement(QueryMapper.updateAvailtrucks);
			preparestatement.setInt(1,truckbean.getTruckId());
			preparestatement.executeUpdate();
			}
		}catch(SQLException e)
		{
		throw new TSException("Prepared Statement is not created");
		}
		return result;
	}

}
