package com.example.springboot.crudDemo.rest;

import com.example.springboot.crudDemo.dao.EmployeeDAO;
import com.example.springboot.crudDemo.dao.EmployeeImp;
import com.example.springboot.crudDemo.entity.Employee;
import com.example.springboot.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController() {
    }

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findEmp(@PathVariable int empId){
        Employee theEmp= employeeService.findEmp(empId);
        if (theEmp==null){
            throw new RuntimeException("EmployeeId not Found - "+empId);
        }
        return  theEmp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmp){
//        Set id = 0 ,if they Pass id just in case
//        this will trigger save new item -> instead of update
        theEmp.setId(0);
        Employee newEmp=employeeService.save(theEmp);
        return newEmp;
    }


}
