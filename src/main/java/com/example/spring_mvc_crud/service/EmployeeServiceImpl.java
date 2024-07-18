package com.example.spring_mvc_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_mvc_crud.dao.EmployeeRepository;
import com.example.spring_mvc_crud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}
	
	@Override
	public Employee findById(Integer id) {
		Optional<Employee> optEmployee = employeeRepository.findById(id);
		
		Employee tempEmployee = null;
		
		if (optEmployee.isPresent()) {
			tempEmployee = optEmployee.get();
		} else {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		return tempEmployee;
		
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(Integer id) {
		employeeRepository.deleteById(id);
	}

}
