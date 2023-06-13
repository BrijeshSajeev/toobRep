package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.entity.Student;
import java.util.List;
public interface StudentDAO {

    List<Employee> findAll();

}
