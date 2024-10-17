package com.example.studentmaintenance.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.studentmaintenance.pojo.Subject;

public interface SubjectRepo extends MongoRepository<Subject, String> {

}
