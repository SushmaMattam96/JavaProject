package com.cg.ems.main;

import java.util.Scanner;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServicelmpl;

public class FectingDataOfEmployee {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Id:");
		int id=scan.nextInt();
		Employee employee=new Employee();
		employee.setId(id);
		EmployeeService employeeService=new EmployeeServicelmpl();
		try {
			employeeService.getAlldetailsofemp(id);
			System.out.println(employee.getId()+employee.getName()+employee.getSalary()+employee.getAddress());
		} catch (EMSException e) {
			System.out.println("no connection");
		}
	}

}
