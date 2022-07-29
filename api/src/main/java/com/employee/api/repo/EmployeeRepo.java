package com.employee.api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.api.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByName(String name);

	@Query(value = "select id, name, salary, designation from employee order by salary desc, name asc", nativeQuery = true)
	public List<Employee> findAllBySalary();

}
