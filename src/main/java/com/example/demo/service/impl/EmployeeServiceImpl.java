package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(long id) {
		/*
		 * Optional<Employee> employee = employeeRepository.findById(id); if
		 * (employee.isPresent()) { return employee.get(); } else { throw new
		 * ResourceNotFoundException("Employee", "Id", "id"); }
		 */

		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether id exists
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));
		employeeRepository.deleteById(id);

	}

}
