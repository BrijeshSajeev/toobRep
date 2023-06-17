package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees=employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employee/list-employees";
	}

	@GetMapping("/showFormToAdd")
	public String showFormToAdd(Model theModel){
		Employee thEmp=new Employee();
		theModel.addAttribute("employee",thEmp);
		return "employee/save-employee";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmp){
		employeeService.save(theEmp);

//		Redirecting to the site to avoid duplicate Submition
		return "redirect:/employees/list";
	}

}









