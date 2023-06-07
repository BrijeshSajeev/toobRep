package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student theStd);
    public Student findById(Integer id);
}
