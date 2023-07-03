package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Course;
import com.example.crudDemo.entity.Instructor;
import com.example.crudDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Transactional
    public void saveByInsDetail(InstructorDetail theInstructor) {
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
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail theInsDet=entityManager.find(InstructorDetail.class,theId);
        entityManager.remove(theInsDet);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        TypedQuery<Course> theQuery= entityManager.createQuery("from Course where instructor.id =:data",Course.class);
        theQuery.setParameter("data",theId);
        List<Course> newCourses=theQuery.getResultList();

        return newCourses;
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class,theId);
    }


}
