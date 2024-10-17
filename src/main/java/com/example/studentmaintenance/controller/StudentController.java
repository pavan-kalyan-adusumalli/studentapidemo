package com.example.studentmaintenance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmaintenance.pojo.Student;
import com.example.studentmaintenance.service.StudentServiceImpl;

@RestController
@RequestMapping("/")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentServiceImpl studentService;

	@GetMapping("/getstudent/{id}")
	public Student getStudentById(@PathVariable String id)
	{
		try {
			return studentService.getStudentById(id);
		}
		catch(Exception e)
		{
			logger.error("Exception while fettching employee with mentioned ID" + id);
			logger.error(e.getMessage());
			return null;
		}
	}
	
	@GetMapping("/getallstudents")
	public List<Student> getAllStudents()
	{
		List<Student> students =  studentService.getAllStudents();
		return students;
	}
	
	@PostMapping("/createstudentprofile")
	public ResponseEntity<String> createStudentProfile(@RequestBody Student student)
	{
		Student savedEntity = studentService.insertStudent(student);
		if(null != savedEntity)
		{
			return new ResponseEntity<>(savedEntity.toString(), HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error in saving entity", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updatestudentprofile")
	public ResponseEntity<String> updateStudentProfile(@RequestBody Student student)
	{
		Student savedEntity = studentService.updateStudent(student);
		if(null != savedEntity)
		{
			return new ResponseEntity<>(savedEntity.toString(), HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error in Updating entity", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deletestudentbyid/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable String id)
	{
		try {
			studentService.deleteById(id);	
		}
		catch(Exception e)
		{
			logger.error("Error in deleting Student");
			logger.error(e.getMessage());
			return new ResponseEntity<>("Error in deleting Student document", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Student Document has been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/findbyname/{name}")
	public List<Student> findStudentByName(@PathVariable String name)
	{
		return studentService.findStudentByName(name);
	}
	
	@GetMapping("findbynameandemail")
	public Student findByNameAndEmail(@RequestParam String name, @RequestParam String mail)
	{
		return studentService.findByNameandMail(name, mail);
	}
	
	@GetMapping("findbynameoremail")
	public List<Student> findByNameOrEmail(@RequestParam String name, @RequestParam String mail)
	{
		return studentService.findByNameoremail(name, mail);
	}
	
	@GetMapping("findbypage")
	public List<Student> findByPage(@RequestParam int pageNo, @RequestParam int size)
	{
		return studentService.findFirstTen(pageNo, size);
	}
	
	@GetMapping("getsortedorder/{property}")
	public List<Student> findSortedStudentsByName(@PathVariable String property)
	{
		return studentService.findSortedOrder(property);
	}
	
	@GetMapping("findbydeptname/{deptname}")
	public List<Student> findBydeptName(@PathVariable String deptname)
	{
		return studentService.findByDepartmentName(deptname);
	}
	
	@GetMapping("findbysubjectname/{subname}")
	public List<Student> findBySubjectName(@PathVariable String subname)
	{
		return studentService.findBySubjectName(subname);
	}
	
	@GetMapping("findNameLike/{name}")
	public List<Student> findNameLike(@PathVariable String name)
	{
		return studentService.findNameLike(name);
	}
	
	@GetMapping("findnamestartswith/{name}")
	public List<Student> findNameStartswith(@PathVariable String name)
	{
		return studentService.findNameStartsWith(name);
	}
	
	@GetMapping("findbydeptid/{deptid}")
	public Student getDocumentByDepRefId(@PathVariable String deptid)
	{
		return studentService.getDocumentByDepRefId(deptid);
	}
	
	@GetMapping("/findbynamenative/{name}")
	public List<Student> findStudentsByNativeName(@PathVariable String name)
	{
		return studentService.getStudentByNativeName(name);
	}
}
