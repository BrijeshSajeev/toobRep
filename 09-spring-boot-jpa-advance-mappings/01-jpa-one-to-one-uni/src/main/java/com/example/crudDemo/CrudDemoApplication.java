package com.example.crudDemo;

import com.example.crudDemo.dao.AppDao;
import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
//			saveInstructor(appDao);
//			findByIdIns(appDao);

			deleteByIdIns(appDao);
			

		};
	}

	private void deleteByIdIns(AppDao appDao) {
	}

	private void findByIdIns(AppDao appDao) {

		int id =2;
		Instructor theIns = appDao.findInstructorById(id);
		System.out.println(theIns);


	}

	private void saveInstructor(AppDao appDao) {

		Instructor theIns=new Instructor("Brijesh","Sajeev","brijesh@gmail.com");

		InstructorDetail newInsDet=new InstructorDetail("you@brijesh.com","Programming");
		theIns.setInstructorDetail(newInsDet);

		appDao.save(theIns);
		System.out.println(theIns.toString());


	}


}
