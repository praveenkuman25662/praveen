package com.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.exception.EmployeeAlreadyExistsException;
import com.employee.api.model.Employee;
import com.employee.api.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@ExceptionHandler(value = EmployeeAlreadyExistsException.class)
	public ResponseEntity handleEmployeeAlreadyExistsException(
			EmployeeAlreadyExistsException EmployeeAlreadyExistsException) {
		return new ResponseEntity("Employee already exists!", HttpStatus.CONFLICT);
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@PutMapping("/updateEmployee/{id}/{salary}")
	public Employee updateEmployee(@PathVariable double salary, @PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);

	}
}
