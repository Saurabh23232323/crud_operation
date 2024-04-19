package com.example.New.Project.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.New.Project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	public List<Employee>findAllByOrderByFirstNameAsc();
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
	
}
