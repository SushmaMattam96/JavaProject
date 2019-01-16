package com.cg.ems.main;

import java.util.List;
import java.util.Scanner;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServicelmpl;

public class ModifyMain {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the salary:");
		double salary=scan.nextDouble();
		EmployeeService employeeService=new EmployeeServicelmpl();
		List<Employee> list;
		try {
			list = employeeService.getSelectEmployees(salary);
			while(list.size()>0)
			{
				System.out.println("Id         Name");
				for(Employee employee:list)
				{
					System.out.println(employee.getId()+ "    " +employee.getName());
				}
			}
		} catch (EMSException e) {
			System.out.println("No connection");
		}
	}

}
