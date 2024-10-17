package com.example.studentmaintenance.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "subject")
public class Subject {
	
	@Id
	private String id;
	
	@Field(name = "subject_name")
	private String subjectName;
	
	@Field(name = "Marks_obtained")
	private Integer markObtained;

	
	public Subject(String subjectName, int markObtained) {
		super();
		this.subjectName = subjectName;
		this.markObtained = markObtained;
	}
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarkObtained() {
		return markObtained;
	}

	public void setMarkObtained(int markObtained) {
		this.markObtained = markObtained;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", markObtained=" + markObtained + "]";
	}

}
