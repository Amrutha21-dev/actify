package com.example.actify.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.actify.model.Employee;
import com.example.actify.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/listAllEmployees")
	public List<Employee> listAllEmployees(){
		return employeeService.listAllEmployees();
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") int id){
		employeeService.deleteEmployee(id);
	}
	   
	@GetMapping("/getEmployeeData/{id}")
	public Employee getEmployeeData(@PathVariable("id") int id){
		return employeeService.getEmployeeData(id);
	}
	
	@PostMapping("/addEmployeeData")
	public Employee addEmployeeData(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
}
