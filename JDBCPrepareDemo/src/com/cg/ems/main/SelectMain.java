package com.cg.ems.main;

import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServicelmpl;

public class SelectMain {
	public static void main(String args[])
	{
		EmployeeService service=new EmployeeServicelmpl();
		List<Employee> list;
		try {
			list = service.getAllEmployees();
			if(list.size()>0){
				System.out.println("Id"+"  "+"Name"+" "+"Salary");
				for(Employee employee:list)
				{
					System.out.println(employee.getId()+"  "+employee.getName()+"  "+employee.getSalary());
				}
				}else{
					System.out.println("No employees are present");
				}	
		} catch (EMSException e) {
			System.err.println("No employees are present");
		}
		
	}
}
