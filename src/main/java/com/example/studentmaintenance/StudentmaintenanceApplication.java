package com.example.studentmaintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("com.example.studentmaintenance.repo")
@ComponentScan("com.example.*")
@SpringBootApplication
public class StudentmaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmaintenanceApplication.class, args);
	}

}
