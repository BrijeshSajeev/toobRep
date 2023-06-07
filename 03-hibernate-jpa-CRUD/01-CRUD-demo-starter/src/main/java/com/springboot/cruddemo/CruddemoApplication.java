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
//			createStduentDao(studentDAO);
//			createMultipledao(studentDAO);
				readStudent(studentDAO);


			};


		}

	private void readStudent(StudentDAO studentDAO) {
		Student std=studentDAO.findById(1);
		System.out.println(std.toString());
//		System.out.println(std.getFirstName());
	}

	private void createMultipledao(StudentDAO studentDAO) {
		//		Create Student object
		Student std1=new Student("Sherbin","Silas","sherbin@gmail.com");
		Student std2=new Student("Ashik","Jenly","ashik@gmail.com");
		Student std3=new Student("Jhon","Snow","john@gmail.com");
//		Save Student object
		studentDAO.save(std1);
		studentDAO.save(std2);
		studentDAO.save(std3);

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
