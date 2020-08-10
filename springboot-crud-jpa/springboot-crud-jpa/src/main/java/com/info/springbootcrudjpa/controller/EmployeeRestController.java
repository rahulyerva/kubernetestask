package com.info.springbootcrudjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.springbootcrudjpa.model.EmployeeModel;
import com.info.springbootcrudjpa.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService eService) {
		employeeService = eService;
	}

	@GetMapping("/employees")
	public List<EmployeeModel> findAll() {
		List<EmployeeModel> allEmployees = employeeService.findAll();
		return allEmployees;
	}

	@GetMapping("/employees/{employeeId}")
	public EmployeeModel getEmployee(@PathVariable int employeeId) {

		EmployeeModel employeeModel = employeeService.findById(employeeId);

		if (employeeModel == null) {
			throw new RuntimeException("Employee ID not found " + employeeId);
		}
		return employeeModel;

	}

	@PostMapping("/employees")
	public EmployeeModel addEmployee(@RequestBody EmployeeModel employee) {

		employee.setId(0);

		employeeService.save(employee);

		return employee;

	}

	@PutMapping("/employees")
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel employee) {
		employeeService.save(employee);

		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		
		EmployeeModel employee= employeeService.findById(employeeId);
		
		if(employee== null) {
			throw new RuntimeException("Employee not found");
		}

		employeeService.deleteById(employeeId);
	}

}
