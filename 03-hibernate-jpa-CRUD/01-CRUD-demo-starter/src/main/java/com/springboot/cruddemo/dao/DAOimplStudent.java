package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
//        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by id desc",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String LastName) {

        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",LastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateFirstName(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int updateAll() {
        int numRowsUpdated= entityManager.createQuery("UPDATE Student SET lastName='Sajeev' where lastName='S A'").executeUpdate();
        return numRowsUpdated;
    }
}
