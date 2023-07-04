package com.example.crudDemo;

import com.example.crudDemo.dao.AppDao;
import com.example.crudDemo.entity.*;
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

		deleteTheStudent(appDao);

		};

	}

	private void deleteTheStudent(AppDao appDao) {
		appDao.deleteStudent(1);
	}


	private void addMoreCourseToStudent(AppDao appDao) {
		Student std=appDao.findStudentByStudentId(1);
		std.addCourse(new Course("data structures"));
		std.addCourse(new Course("Spring"));
		std.addCourse(new Course("Communication"));
		System.out.println(std);
		System.out.println(std.getCourses());
		appDao.addMoreCourseToStudent(std);
	}

	private void findStudentByCourseId(AppDao appDao) {

		Course theC=appDao.findStudentByCourseId(10);
		System.out.println(theC);
		System.out.println(theC.getStudents());
	}

	private void findStudentByStudentId(AppDao appDao) {
	   Student std=appDao.findStudentByStudentId(1);
		System.out.println(std);
		System.out.println(std.getCourses());

	}

	private void addCourse(AppDao appDao) {
		Course theCourse= new Course("C++");
		theCourse.addStudent(new Student("Sherbin","Sailas","Sherbin@gmail.com"));
		theCourse.addStudent(new Student("Brijesh","Sajeev","brijesh@gmail.com"));

		appDao.addCourseWithStd(theCourse);

	}

	//--------------------------ManyToMany
	private void addStudentAndCourse(AppDao appDao) {
		Student std=new Student("Sherbin","Sailas","Sherbin@gmail.com");
		std.addCourse(new Course("Java"));
		std.addCourse(new Course("Python"));
		std.addCourse(new Course("C++"));

		appDao.addStudent(std);



	}




//---------------------------ManyToOne


	private void deleteTheCourseAndReview(AppDao appDao) {
		appDao.deleteCourseById(10);
	}

	private void findCourseByCourseId(AppDao appDao) {

//		Course theCourse=appDao.getCourseByCourseId(10);
		Course theCourse=appDao.getCourseByCourseIdJoinFetch(10);
		System.out.println(theCourse);
		System.out.println(theCourse.getReviews());
	}

	private void saveCourseAndReviews(AppDao appDao) {
		Course newCourse=new Course("Java");
		newCourse.add(new Review("Wonderful experience"));
		newCourse.add(new Review("just wow!"));
		newCourse.add(new Review("Try to explain deeply."));

		System.out.println(newCourse);
		System.out.println(newCourse.getReviews());

		appDao.addCourseAndReview(newCourse);


	}

	private void deleteTheCourse(AppDao appDao) {

//		appDao.deleteCourseById(12);
		appDao.deleteCourseById(13);
	}

	private void updateInstructor(AppDao appDao) {

		Instructor theIns=appDao.findCourseByInstructorJoinFetch(1);


		Course crs1= new Course("Nano Tech");
		crs1.setInstructor(theIns);
		List<Course> newCourse=theIns.getCourses();
		newCourse.add(crs1);
		theIns.setCourses(newCourse);

		appDao.update(theIns);
		System.out.println("Done!");

				findCoursesByInstructorJoinFetch(appDao);

	}

	private void findCoursesByInstructorJoinFetch(AppDao appDao) {

			Instructor theIns=appDao.findCourseByInstructorJoinFetch(1);
		System.out.println(theIns);
		System.out.println(theIns.getCourses());

	}

	private void findCoursesByInstructor(AppDao appDao) {
			Instructor theIns=appDao.findInstructorById(1);
		System.out.println(theIns);
		   List<Course> newCourse= appDao.findCourseByInstructorId(1);
		   theIns.setCourses(newCourse);
		System.out.println(theIns.getCourses());


	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor theIns=new Instructor("Sherbin","sailas","sherbin@gmail.com");

		InstructorDetail newInsDet=new InstructorDetail("you@sherbin.com","Programming");
		theIns.setInstructorDetail(newInsDet);
		Course newCourse1=new Course("JS");
		Course newCourse2=new Course("C");

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
		int id =3;
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
