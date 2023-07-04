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
import java.util.Optional;

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
        List<Course> theCourses= theIns.getCourses();
        for(Course c:theCourses){
            c.setInstructor(null);
        }

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
    public Instructor findCourseByInstructorJoinFetch(int theId) {

        TypedQuery<Instructor> theQuery=entityManager.createQuery("select i from Instructor i "
                        +"JOIN FETCH i.courses "
                        +"where i.id=:data", Instructor.class);

        theQuery.setParameter("data",theId);
        Instructor theIns=theQuery.getSingleResult();


        return theIns;
    }

    @Override
    @Transactional
    public void update(Instructor theIns) {
        entityManager.merge(theIns);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course theCourse=entityManager.find(Course.class,theId);
        entityManager.remove(theCourse);
    }

    @Override
    @Transactional
    public void addCourseAndReview(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course getCourseByCourseId(int theId) {
        Course result= entityManager.find(Course.class,theId);

        return result;
    }

    @Override
    public Course getCourseByCourseIdJoinFetch(int theId) {
        TypedQuery<Course> theQuery=entityManager.createQuery("select c from Course c "
                        +"JOIN FETCH c.reviews "+"where c.id=:data", Course.class
                    );
        theQuery.setParameter("data",theId);




        return theQuery.getSingleResult();
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class,theId);
    }


}
