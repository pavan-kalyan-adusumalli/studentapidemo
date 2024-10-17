package com.example.studentmaintenance.pojo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
	
	@Id
	private String id;
	
	private String name;
	private Integer age;
	private String mail;
	
	@DBRef
	private List<Subject> subjects;
	
	@DBRef
	private Department department;
	
	@Transient
	private Boolean major;
	
	
	public Student(String id, String name, Integer age, String mail, Department department, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mail = mail;
		this.department = department;
		this.subjects = subjects;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void isMajor()
	{
		if(this.age >= 18)
			this.major = true;
		else
			this.major = false;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mail=" + mail + ", subjects=" + subjects
				+ ", department=" + department + ", Major=" + major + "]";
	}	
	
	
}
