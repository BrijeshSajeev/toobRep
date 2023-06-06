package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		@Bean
		public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
			return runner->{
			createStduentDao(studentDAO);
			};

		}

	private void createStduentDao(StudentDAO studentDAO) {
//		Create Student object
		Student std=new Student("Brijesh","Sajeev","brijeshnopzz@gmail.com");
//		Save Student object
		studentDAO.save(std);
//		print
		System.out.println("The Id is : " + std.getId());
		std.toString();
	}
}
