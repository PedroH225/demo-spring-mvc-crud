package com.example.spring_mvc_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_mvc_crud.entity.Employee;
import com.example.spring_mvc_crud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employees = service.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		
		service.save(employee);
		
		return "redirect:/employees/list";
	}
}
