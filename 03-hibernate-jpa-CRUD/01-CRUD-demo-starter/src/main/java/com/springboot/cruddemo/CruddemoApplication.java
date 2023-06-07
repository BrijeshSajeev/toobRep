package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
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
		public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
			return runner->{
//			createStduentDao(studentDAO);
//			createMultipledao(studentDAO);
//				readStudent(studentDAO);
//	Quering Objects
//			queryForStudent(studentDAO);
			findStudent(studentDAO);



			};


		}

	private void findStudent(StudentDAO studentDAO) {

		List<Student> stds=studentDAO.findByLastName("Sajeev");
		for(Student std:stds){
			System.out.println("----------------------");
			System.out.println(std);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {

		List<Student> stds = studentDAO.findAll();

		for (Student std:stds
			 ) {
			System.out.println("---------------------------------");
			System.out.println(std);
		}

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
		Student std=new Student("Brishika","Sajeev","brishika@gmail.com");
//		Save Student object
		studentDAO.save(std);
//		print
		System.out.println("The Id is : " + std.getId());
		std.toString();
	}
}
