package com.techleads.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Employee;
import com.techleads.app.service.EmployeeService;
@RestController
@Validated
public class EmployeeController {
	private EmployeeService employeeService;
	
	
	
	
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@PostMapping(value = {"/emps"})
	public Employee saveEmployee(@Valid @RequestBody Employee employee, @RequestHeader("memberNo") String memberNo) {
		employeeService.validateLocationName(employee, memberNo);
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return saveEmployee;
	}
	
	@GetMapping(value = {"/emps"})
	public List<Employee> findAllEmployees(@RequestHeader(value = "idClaim") @NotBlank(message = "id claim is mandatory") String idClaim) {
		List<Employee> findAllEmployees = employeeService.findAllEmployees();
		return findAllEmployees;
	}
	
	@GetMapping(value = {"/emps/{id}"})
	public Employee findEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = employeeService.findEmployeeById(id);
		return employee;
	}

}
