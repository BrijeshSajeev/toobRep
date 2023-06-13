package com.example.springboot.crudDemo;

import com.example.springboot.crudDemo.dao.EmployeeDAO;
import com.example.springboot.crudDemo.dao.EmployeeImp;
import com.example.springboot.crudDemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunner(EmployeeDAO employeeDAO) {
        return runner -> {
//
            queryForStudent(employeeDAO);
        };


    }


    private void queryForStudent(EmployeeDAO employeeDAO) {

        List<Employee> emps = employeeDAO.findAll();

        for (Employee emp : emps
        ) {
            System.out.println("---------------------------------");
            System.out.println(emp);
        }

    }

}
