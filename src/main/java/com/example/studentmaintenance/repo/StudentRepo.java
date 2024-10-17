package com.example.studentmaintenance.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.studentmaintenance.pojo.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
	public List<Student> findByName(String name);
	
	public Student findByNameAndMail(String name, String mail);
	
	public List<Student> findByNameOrMail(String name, String mail);
	
	public List<Student> findByDepartmentDepartmentName(String departmentName);
	
	public List<Student> findBySubjectsSubjectName(String subjectName);
	
	public List<Student> nameLike(String name);
	
	public List<Student> nameStartsWith(String name);
	
	public Student findByDepartment(String id);
	
	@Query(" {\"name\" : \"?0\" } ")
	public List<Student> findByNameNative(String name);
}
