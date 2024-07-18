package com.example.spring_mvc_crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_mvc_crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
