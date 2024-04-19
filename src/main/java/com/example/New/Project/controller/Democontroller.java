package com.example.New.Project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.New.Project.entity.Employee;
import com.example.New.Project.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class Democontroller {
	private EmployeeService employeeservice;

	public Democontroller(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> theEmployees=employeeservice.findAll();
		
		model.addAttribute("employees",theEmployees);
		return "list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee=new Employee();
		model.addAttribute("employee",theEmployee);
		return "employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {
		
		employeeservice.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int theId) {
		employeeservice.deleteById(theId);
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,  Model theModel) {

Employee theEmployee=employeeservice.findById(theId);

		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}	
	@GetMapping("/search")
	public String searchMethod(@RequestParam("employeeName") String theName, Model theModel) {
		
		
		List<Employee> theEmployees = employeeservice.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "/list-employees";
		
	}



}
