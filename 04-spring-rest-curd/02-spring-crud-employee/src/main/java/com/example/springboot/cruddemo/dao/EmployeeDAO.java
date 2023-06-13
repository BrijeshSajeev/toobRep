package com.example.springboot.crudDemo.dao;

import com.example.springboot.crudDemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    public Employee findEmp(int theId);

    public Employee save(Employee theEmp);

    public void deleteById(int theId);
}
