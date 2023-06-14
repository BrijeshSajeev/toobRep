package com.example.springboot.crudDemo.dao;

import com.example.springboot.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    Nothing but Custom Methods
}
