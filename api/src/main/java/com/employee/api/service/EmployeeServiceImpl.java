package com.employee.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.api.exception.EmployeeAlreadyExistsException;
import com.employee.api.model.Employee;
import com.employee.api.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee existingEmployee = employeeRepo.findByName(employee.getName());
		if (existingEmployee == null) {
			employeeRepo.save(employee);
			return "Employee added successfully";
		} else
			throw new EmployeeAlreadyExistsException("Employee already exists!!");
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepo.findById(id);
		Employee emp1 = emp.get();
		emp1.setName(employee.getName());
		emp1.setSalary(employee.getSalary());
		emp1.setDesignation(employee.getDesignation());
		employeeRepo.save(emp1);
		return emp1;

	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAllBySalary();
	}

}
