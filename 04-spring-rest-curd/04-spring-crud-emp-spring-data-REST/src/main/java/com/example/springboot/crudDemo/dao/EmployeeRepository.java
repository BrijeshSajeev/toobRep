package com.example.springboot.crudDemo.dao;

import com.example.springboot.crudDemo.entity.Doctor;
import com.example.springboot.crudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

public interface EmployeeRepository extends JpaRepository<Doctor, Integer> {
//    Nothing but Custom Methods
}
