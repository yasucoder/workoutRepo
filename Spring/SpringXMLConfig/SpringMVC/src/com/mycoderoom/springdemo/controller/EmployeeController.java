package com.mycoderoom.springdemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycoderoom.springdemo.model.Employee;

@Component
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping("/showform")
	public String showform(Model themodel) {
		// Create a student object
		Employee theEmp = new Employee();
		// add student object to the model
		themodel.addAttribute("employee", theEmp);

		return "employee-form";
	}

	@RequestMapping("/processform")
	public String processform(@ModelAttribute("employee") Employee theEmployee) {
		System.out.println("The Employee" + theEmployee.getFirstName() + " "
				+ theEmployee.getLastName());
		return "employee-confrimation";
	}

}
