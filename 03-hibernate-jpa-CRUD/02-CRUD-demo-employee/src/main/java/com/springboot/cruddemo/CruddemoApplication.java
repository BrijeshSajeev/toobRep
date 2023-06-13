package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import  java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//
			queryForStudent(studentDAO);
		};


	}


	private void queryForStudent(StudentDAO studentDAO) {

		List<Employee> stds = studentDAO.findAll();

		for (Employee std : stds
		) {
			System.out.println("---------------------------------");
			System.out.println(std);
		}

	}

}