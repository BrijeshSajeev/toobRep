package com.example.springboot.crudDemo.service;

import com.example.springboot.crudDemo.dao.EmployeeRepository;
import com.example.springboot.crudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll() ;
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee emp=null;
        if(result.isPresent()){
            emp=result.get();
        }
        else {
            throw new RuntimeException("Employee Not Found - " +theId); 
        }
        return emp;
    }

    @Override
    public Employee save(Employee theEmp) {
        return employeeRepository.save(theEmp);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
