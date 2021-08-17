package com.techleads.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techleads.app.exceptions.EmployeeNotFound;
import com.techleads.app.model.Employee;

@Service
public class EmployeeService {

	private static List<Employee> emps;
	static {
		emps = new ArrayList<>();
		emps.add(new Employee(101, "Emp-1"));
	}

	public List<Employee> findAllEmployees() {
		return emps;
	}

	public Employee findEmployeeById(Integer id) {
		Optional<Employee> findAny = emps.stream().filter(emp -> emp.getId().equals(id)).findAny();
		if(!findAny.isPresent()) {
			throw new EmployeeNotFound();
		}else {
			return findAny.get();
		}
		
	}

	public Employee saveEmployee(Employee employee) {

		emps.add(employee);

		return findEmployeeById(employee.getId());
	}

}
