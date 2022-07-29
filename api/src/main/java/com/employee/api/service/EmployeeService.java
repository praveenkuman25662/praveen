package com.employee.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.api.exception.EmployeeAlreadyExistsException;
import com.employee.api.model.Employee;

@Service
public interface EmployeeService {
	public String addEmployee(Employee employee) throws EmployeeAlreadyExistsException;

	public List<Employee> getAllEmployee();

	public Employee updateEmployee(Employee employee, int id);

}
