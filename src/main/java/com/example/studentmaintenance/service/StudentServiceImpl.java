package com.example.studentmaintenance.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.studentmaintenance.pojo.Student;
import com.example.studentmaintenance.repo.DepartmentRepo;
import com.example.studentmaintenance.repo.StudentRepo;
import com.example.studentmaintenance.repo.SubjectRepo;

@Service
public class StudentServiceImpl {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@Autowired
	SubjectRepo subjectRepo;
	
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public Student getStudentById(String id)
	{
			return studentRepo.findById(id).get();	
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> students =  studentRepo.findAll();
		return students;
	}
	
	public Student insertStudent(Student studentEntity)
	{
		if(studentEntity.getDepartment() != null)
			departmentRepo.save(studentEntity.getDepartment());
		if(studentEntity.getSubjects() != null && studentEntity.getSubjects().size() > 0)
			subjectRepo.saveAll(studentEntity.getSubjects());
		return studentRepo.save(studentEntity);
	}
	
	public Student updateStudent(Student studentEntity)
	{
		// need to provide id along with RequestBody
		// if id is there inside database, this will update the existing document
		// else it will create a new document
		return studentRepo.save(studentEntity);
	}
	
	public void deleteById(String id)
	{
		studentRepo.deleteById(id);
	}
	
	public void deleteByBody(Student studentEntity)
	{
		studentRepo.delete(studentEntity);
	}
	
	public List<Student> findStudentByName(String name)
	{
		return studentRepo.findByName(name);
	}
	
	public Student findByNameandMail(String name, String email)
	{
		return studentRepo.findByNameAndMail(name, email);
	}
	
	public List<Student> findByNameoremail(String name, String email)
	{
		return studentRepo.findByNameOrMail(name, email);
	}
	
	public List<Student> findFirstTen(int pageNumber, int pageSize)
	{
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		return studentRepo.findAll(pageable).getContent();
	}
	
	public List<Student> findSortedOrder(String property)
	{
		Sort sort = Sort.by(Sort.Direction.ASC, property);
		return studentRepo.findAll(sort);
	}
	
	public List<Student> findByDepartmentName(String deptName)
	{
		return studentRepo.findByDepartmentDepartmentName(deptName);
	}
	
	public List<Student> findBySubjectName(String subName)
	{
		return studentRepo.findBySubjectsSubjectName(subName);
	}
	
	public List<Student> findNameLike(String name)
	{
		return studentRepo.nameLike(name);
	}
	
	public List<Student> findNameStartsWith(String name)
	{
		return studentRepo.nameStartsWith(name);
	}
	
	public Student getDocumentByDepRefId(String deptId)
	{
		return studentRepo.findByDepartment(deptId);
	}
	
	public List<Student> getStudentByNativeName(String name)
	{
		return studentRepo.findByNameNative(name);
	}
}

