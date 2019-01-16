package com.cg.ems.service;

import java.util.List;


import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDAOlmpl;
import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeServicelmpl implements EmployeeService 
{
	EmployeeDAO employeeDao= new EmployeeDAOlmpl();
	@Override
	public int insertEmployee(Employee employee)throws EMSException {

		return employeeDao.insertEmployee(employee) ;
	}
	public int updateEmployee(Employee employee)throws EMSException {

		return employeeDao.updateEmployee(employee) ;
	}
	public List<Employee> getAllEmployees() throws EMSException {
		
		return employeeDao.getAllEmployees();
	}
	@Override
	public List<Employee> getSelectEmployees(double salary) throws EMSException {
		
		return employeeDao.getSelectEmployees(salary);
	}
	@Override
	public Employee getAlldetailsofemp(int id) throws EMSException {
		
		return employeeDao.getAlldetailsofemp(id);
	}

}
