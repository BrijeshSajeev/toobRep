package com.example.crudDemo;

import com.example.crudDemo.dao.AppDao;
import com.example.crudDemo.entity.Course;
import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//			deleteByIdIns(appDao);
//			findInsDetailById(appDao);
//			saveInstructorDetail(appDao);
//			deleteByIdInsDetail(appDao);

//			createInstructorWithCourse(appDao);

			findCoursesByInstructor(appDao);
		};
	}

	private void findCoursesByInstructor(AppDao appDao) {
			Instructor theIns=appDao.findInstructorById(1);
		System.out.println(theIns);
		   List<Course> newCourse= appDao.findCourseByInstructorId(1);
		   theIns.setCourses(newCourse);
		System.out.println(theIns.getCourses());


	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor theIns=new Instructor("Brijesh","Sajeev","brijesh@gmail.com");

		InstructorDetail newInsDet=new InstructorDetail("you@brijesh2.com","Programming");
		theIns.setInstructorDetail(newInsDet);
		Course newCourse1=new Course("Java");
		Course newCourse2=new Course("Python");

		theIns.add(newCourse1);
		theIns.add(newCourse2);

		System.out.println("The Instructor "+ theIns);
		System.out.println("The Courses"+theIns.getCourses());

		appDao.save(theIns) ;

	}

	private void saveInstructorDetail(AppDao appDao) {

		Instructor theIns=new Instructor("Brijesh2","Sajeev","brijesh2@gmail.com");

		InstructorDetail newInsDet=new InstructorDetail("you@brijesh2.com","Programming");

		newInsDet.setInstructor(theIns);
		appDao.saveByInsDetail(newInsDet);

	}

	private void deleteByIdInsDetail(AppDao appDao) {

		appDao.deleteInstructorDetailById(3);
		System.out.println("SucessFull");

	}

	private void findInsDetailById(AppDao appDao) {
		InstructorDetail insDet=appDao.findInstructorDetailById(3);
		System.out.println(insDet);
		Instructor ins=insDet.getInstructor();
		System.out.println(ins);
	}

	private void deleteByIdIns(AppDao appDao) {
		int id =2;
		 appDao.deleteInstructorById(id);
		System.out.println("Deleted Successfully");
	}

	private void findByIdIns(AppDao appDao) {

		int id =2;
		Instructor theIns = appDao.findInstructorById(id);
		System.out.println(theIns);


	}

	private void saveInstructor(AppDao appDao) {

		Instructor theIns=new Instructor("Brijesh2","Sajeev","brijesh2@gmail.com");

		InstructorDetail newInsDet=new InstructorDetail("you@brijesh2.com","Programming");
		theIns.setInstructorDetail(newInsDet);

		appDao.save(theIns);
		System.out.println(theIns.toString());


	}


}
