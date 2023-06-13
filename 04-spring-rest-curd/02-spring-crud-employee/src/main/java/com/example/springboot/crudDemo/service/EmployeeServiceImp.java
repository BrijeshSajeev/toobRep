package com.example.springboot.crudDemo.service;

import com.example.springboot.crudDemo.dao.EmployeeDAO;
import com.example.springboot.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImp(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll() ;
    }

    @Override
    @Transactional
    public Employee findEmp(int theId) {
        return employeeDAO.findEmp(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmp) {
        return employeeDAO.save(theEmp);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
