package com.example.demo.service

import com.example.demo.model.Employee
import java.util.List

public interface EmployeeService {
	Employee saveEmployee(Employee employee)

	List<Employee> getAllEmployee()

	Employee getEmployeebyId(long id)

	void deleteEmployee(long id)
}
