package com.techleads.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.exceptions.LocationFieldNotFoundException;
import com.techleads.app.model.Employee;
import com.techleads.app.service.EmployeeService;
@RestController
public class EmployeeController {
	private EmployeeService employeeService;
	
	
	
	
	
	@Autowired
	private EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@PostMapping(value = {"/emps"})
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		employeeService.validateLocationName(employee);
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return saveEmployee;
	}
	
	@GetMapping(value = {"/emps"})
	public List<Employee> findAllEmployees() {
		List<Employee> findAllEmployees = employeeService.findAllEmployees();
		return findAllEmployees;
	}
	
	@GetMapping(value = {"/emps/{id}"})
	public Employee findEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = employeeService.findEmployeeById(id);
		return employee;
	}

}
