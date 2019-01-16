package com.cg.ems.model;

public class Employee {
 
private int Id;
private  String Name;
private Double Salary;
private String Address;

public Employee(int id, String name, Double salary, String address) {
	super();
	Id = id;
	Name = name;
	Salary = salary;
	Address = address;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Double getSalary() {
	return Salary;
}
public void setSalary(Double salary) {
	Salary = salary;
}

public Employee(){
	
}

}
