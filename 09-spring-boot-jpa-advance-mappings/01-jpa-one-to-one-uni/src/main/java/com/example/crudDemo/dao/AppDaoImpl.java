package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements AppDao{


    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
       Instructor theIns =entityManager.find(Instructor.class,theId);
        return theIns;
    }


    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theIns =entityManager.find(Instructor.class,theId);
        entityManager.remove(theIns);
    }
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class,theId);
    }


}
