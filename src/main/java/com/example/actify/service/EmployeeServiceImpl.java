package com.example.actify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actify.model.Employee;
import com.example.actify.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeData(int id) {
		if(!employeeRepository.findById(id).isEmpty()) {
			return employeeRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		if(getEmployeeData(id) != null) {
			employeeRepository.deleteById(id);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
