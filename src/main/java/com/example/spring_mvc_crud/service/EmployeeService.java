package com.example.spring_mvc_crud.service;

import java.util.List;

import com.example.spring_mvc_crud.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(Integer id);

	Employee save(Employee employee);

	void deleteById(Integer id);
}
