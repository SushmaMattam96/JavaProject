package com.cg.ems.main;

import java.util.Scanner;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServicelmpl;

public class MainFunct {
 public static void  main(String args[])
 {
	 Scanner scan= new Scanner(System.in);
	 System.out.println("Enter Name");
	 String name=scan.nextLine();
	 System.out.println("Enter Salary");
	 Double salary=scan.nextDouble();
	 Employee employee=new Employee();
	 employee.setName(name);
	 employee.setSalary(salary);
	 
	 EmployeeService service=new EmployeeServicelmpl();
	 try {
		int result=service.insertEmployee(employee);
		System.out.println(result+"employee inserted");
	} catch (EMSException e) {
		System.out.println(e.getMessage());
	}
	 scan.close();
 }
}
