package com.techleads.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.techleads.app.exceptions.EmployeeNotFound;
import com.techleads.app.exceptions.LocationFieldNotFoundException;
import com.techleads.app.exceptions.MemberNumberInvalidException;
import com.techleads.app.model.Employee;

@Service
public class EmployeeService {
	private static List<String> locs=new ArrayList<>();

	private static List<Employee> emps;
	static {
		emps = new ArrayList<>();
		emps.add(new Employee(101, "Emp-1", "HYD"));
		locs.add("HYD");
		locs.add("CHN");
		locs.add("BNG");
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
	
	public void validateLocationName(Employee employee, String memberNo) {
		
		validateRequestHeader(memberNo);
		
		boolean flag=false;
		for (String value : locs) {
			if(value.equals(employee.getLocation())) {
				flag=true;
				break;
			}
		}
		if(!flag) { 
			throw new LocationFieldNotFoundException(employee.getLocation()+": Is not a valid name");
			
		}
	}
	
	public void validateRequestHeader(String memberNo) {
		String regex = "[0-9]+";
		
		Pattern pattern = Pattern.compile(regex);
		
		if(!pattern.matcher(memberNo).matches()) {
			throw new MemberNumberInvalidException(memberNo+" is not valid member number");
		}
	}

}
