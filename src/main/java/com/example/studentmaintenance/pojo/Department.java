package com.example.studentmaintenance.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "department")
public class Department {
	
	@Id
	private String id;
	
	@Field(name = "Department_name")
	private String departmentName;
	
	@Field(name = "location")
	private String location;

	public Department(String departmentName, String location) {
		super();
		this.departmentName = departmentName;
		this.location = location;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}
}
