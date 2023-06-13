package com.example.springboot.crudDemo.dao;

import com.example.springboot.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeImp implements EmployeeDAO{

    //    Define field for Entity Manager
    private EntityManager entityManager;

    //    Inject the Entity manager
    @Autowired
    public EmployeeImp(EntityManager theEn){
        entityManager=theEn;
    }

//implement  Save Method

    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee ",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findEmp(int theId) {

    Employee newEmp=entityManager.find(Employee.class,theId);
    return newEmp;
//        return entityManager.find(Employee.class,theId);
    }

    @Override
    public Employee save(Employee theEmp) {

        Employee newEmp = entityManager.merge(theEmp);
        return newEmp;
    }

    @Override
    public void deleteById(int theId) {
        Employee oldEmp=entityManager.find(Employee.class,theId);
        entityManager.remove(oldEmp);
    }

}
