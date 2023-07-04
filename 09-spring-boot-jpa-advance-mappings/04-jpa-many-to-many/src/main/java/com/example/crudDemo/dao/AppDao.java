package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Course;
import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    public void save(Instructor theInstructor);
    public void saveByInsDetail(InstructorDetail theInstructor);
    public Instructor findInstructorById(int theId);

    public InstructorDetail findInstructorDetailById(int theId);

    public void deleteInstructorById(int theId);

    public void deleteInstructorDetailById(int theId);


    List<Course> findCourseByInstructorId(int theId);

    Instructor findCourseByInstructorJoinFetch(int theId);


    void update(Instructor theIns);

    void deleteCourseById(int theId);

    void addCourseAndReview(Course theCourse);

    Course getCourseByCourseId(int theId);
    Course getCourseByCourseIdJoinFetch(int theId);

}
