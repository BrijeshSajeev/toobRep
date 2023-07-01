package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;

public interface AppDao {
    public void save(Instructor theInstructor);
    public Instructor findInstructorById(int theId);

    public InstructorDetail findInstructorDetailById(int theId);

    public void deleteInstructorById(int theId);

    public void deleteInstructorDetailById(int theId);


}
