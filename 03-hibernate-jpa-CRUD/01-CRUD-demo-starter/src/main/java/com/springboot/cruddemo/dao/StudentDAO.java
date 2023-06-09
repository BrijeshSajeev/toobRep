package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;
import java.util.List;
public interface StudentDAO {
    public void save(Student theStd);
    public Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByLastName(String LastName);

    public void updateFirstName(Student theStudent);

    public int updateAll();

    public void deleteStd(Integer id);

    public Integer deleteAll();

}
