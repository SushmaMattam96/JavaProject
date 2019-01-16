package com.cg.ems.dao;

import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeDAO {

	int insertEmployee(Employee employee) throws EMSException;
	

	int updateEmployee(Employee employee) throws EMSException;


	List<Employee> getAllEmployees() throws EMSException;


	List<Employee> getSelectEmployees(double salary) throws EMSException;


	Employee getAlldetailsofemp(int id) throws EMSException;


}
