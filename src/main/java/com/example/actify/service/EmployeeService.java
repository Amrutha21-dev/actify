package com.example.actify.service;

import java.util.List;

import com.example.actify.model.Employee;

public interface EmployeeService {

	public List<Employee> listAllEmployees();
	
	public Employee getEmployeeData(int id);
	
	public void deleteEmployee(int id);
	
	public Employee addEmployee(Employee employee);
}
