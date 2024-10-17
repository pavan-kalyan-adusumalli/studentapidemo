package com.example.studentmaintenance.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmaintenance.pojo.Department;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String>{

}
