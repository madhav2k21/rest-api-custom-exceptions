package com.techleads.app.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	
	@NotNull(message = "id is mandatory")
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(min=1,max=10,message="Size should be between 1 to 6")
	private String name;
	
	@NotBlank(message = "Location is mandatory")
	@Size(min=1,max=10,message="Size should be between 1 to 6")
	private String location;
	
	
	
	public Employee() {
		super();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location=location;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	

}
