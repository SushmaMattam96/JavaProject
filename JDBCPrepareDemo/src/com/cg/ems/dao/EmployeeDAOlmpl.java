package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.utility.JDBCUtility;

public class EmployeeDAOlmpl implements EmployeeDAO {

	PreparedStatement statement = null;
	Connection connection = null;
	int result = 0;
	public int updateEmployee(Employee employee)throws EMSException{
		connection=JDBCUtility.getConnection();
		try{
			statement=connection.prepareStatement(QueryMapper.updateQuery);
			statement.setDouble(1, employee.getSalary());
			statement.setInt(2, employee.getId()); 
			result=statement.executeUpdate();
		} catch(SQLException e){
			throw new EMSException(e.getMessage());
		}finally {
			try{
				statement.close();
			}catch(SQLException e)
			{
				throw new EMSException("Statement closed");
			}
			try{
				connection.close();
			}catch(SQLException e)
			{
				throw new EMSException("Connection wasn't closed");
			}
		}
		return result;
		
	}
	public int insertEmployee(Employee employee) throws EMSException {

		connection = JDBCUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.insertQuery);
			statement.setString(1, employee.getName());
			statement.setDouble(2, employee.getSalary());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("prepared statement not created");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("Statement not closed");
			}
			try {
				connection.close();
			} catch (SQLException e) {
				throw new EMSException("connection not closed");
			}
		}
		return result;
	}
	@Override
	public List<Employee> getAllEmployees() throws EMSException {
		
		List<Employee> list=new ArrayList<>();
		ResultSet resultset=null;
		connection=JDBCUtility.getConnection();
				try{
					statement=connection.prepareStatement(QueryMapper.selectAllEmployeesQuery);
					resultset=statement.executeQuery();
					while(resultset.next()){
						int id=resultset.getInt("id");
						String name=resultset.getString(2);
						double salary=resultset.getDouble("salary");
						
						Employee employee= new Employee();
						employee.setId(id);
						employee.setName(name);
						employee.setSalary(salary);
						list.add(employee);
					}
				}catch(SQLException e){
					throw new EMSException("Statement is not closed");
				}finally{
					try {
						statement.close();
					} catch (SQLException e) {
						throw new EMSException("Statement not closed");
					}
					try {
						connection.close();
					} catch (SQLException e) {
						throw new EMSException("connection not closed");
					}
					try {
						resultset.close();
					} catch (SQLException e) {
						throw new EMSException("Result set not closed");
					}
				}
		return list;
	}
	@Override
	public List<Employee> getSelectEmployees(double salary) throws EMSException {
		
		List<Employee> list=new ArrayList<Employee>();
		connection=JDBCUtility.getConnection();
		ResultSet resultSet=null;
		try {
			statement=connection.prepareStatement(QueryMapper.selectNameEmployeeQuery);
			statement.setDouble(1,salary);
			resultSet=statement.executeQuery();
			int id=resultSet.getInt("id");
			String name=resultSet.getString("name");
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(name);
			list.add(employee);
			
		} catch (SQLException e) {
			throw new EMSException("Prpared statement not created");
		}
		
		
		return list;
	}
	@Override
	public Employee getAlldetailsofemp(int id) throws EMSException {
		connection=JDBCUtility.getConnection();
		ResultSet resultset=null;
		Employee employee=new Employee();
		try{
			statement=connection.prepareStatement(QueryMapper.newSelectQuery);
			statement.setInt(1,id );
			resultset=statement.executeQuery();
			id=resultset.getInt(1);
			String name=resultset.getString("name");
			Double salary=resultset.getDouble("salary");
			String address=resultset.getString("address");
			
			
			employee.setId(id);
			employee.setName(name);
			employee.setSalary(salary);
			employee.setAddress(address);
			
			
		} catch(SQLException e){
			throw new EMSException("Prepared statement not created");
		}finally {
			try{
				statement.close();
			}catch(SQLException e)
			{
				throw new EMSException("Statement closed");
			}
			try{
				connection.close();
			}catch(SQLException e)
			{
				throw new EMSException("Connection wasn't closed");
			}
		}
		return employee;
		
	}

}
