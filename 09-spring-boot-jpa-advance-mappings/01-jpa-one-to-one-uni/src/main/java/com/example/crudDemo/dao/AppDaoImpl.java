package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Instructor;
import jakarta.persistence.Entity;
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
    public void deleteInstructorById(int theId) {
        Instructor theIns =entityManager.find(Instructor.class,theId);
        entityManager.remove(theIns);
    }


}
