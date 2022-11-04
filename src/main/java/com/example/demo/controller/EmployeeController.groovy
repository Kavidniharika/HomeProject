package com.example.demo.controller

import java.util.List

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.example.demo.model.Employee
import com.example.demo.service.EmployeeService

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	private EmployeeService employeeService

	public EmployeeController(EmployeeService employeeService) {
		super()
		this.employeeService = employeeService
	}

	// build CREATE employee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED)
	}

	// build GET all employees REST API
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee()
	}

	// build GET employee by ID REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeebyId(employeeId), HttpStatus.OK)
	}

	// build DELETE employee by id REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id)
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK)
	}
}
