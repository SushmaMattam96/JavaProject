package com.cg.ems.main;

import java.util.Scanner;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServicelmpl;

public class UpdateMain {
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		int id=scanner.nextInt();
		System.out.println("Enter salary");
		double salary=scanner.nextDouble();
		Employee employee=new Employee();
		employee.setId(id);
		employee.setSalary(salary);
		
		EmployeeService service=new EmployeeServicelmpl();
		int result=0;
		try{
			result=service.updateEmployee(employee);
			System.out.println(result + "Updated.." );
			
		}catch(EMSException e)
		{
			System.out.println("Not updated..");
		}
		scanner.close();
 	}
	
	

}
