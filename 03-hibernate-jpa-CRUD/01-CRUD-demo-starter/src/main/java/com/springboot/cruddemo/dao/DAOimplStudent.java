package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOimplStudent implements StudentDAO{

//    Define field for Entity Manager
    private EntityManager entityManager;

//    Inject the Entity manager
    @Autowired
    public DAOimplStudent(EntityManager theEn){
        entityManager=theEn;
    }

//implement  Save Method
    @Override
    @Transactional
    public void save(Student theStd){
        entityManager.persist(theStd);
    }
}
