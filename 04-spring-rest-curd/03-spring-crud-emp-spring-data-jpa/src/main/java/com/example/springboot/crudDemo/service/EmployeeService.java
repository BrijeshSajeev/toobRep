package com.example.springboot.crudDemo.service;

import com.example.springboot.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int theId);

    public Employee save(Employee theEmp);

    public void deleteById(int theId);
}
