package com.example.demo.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;

/**
 * This controller is used for CRUD operations in employee table.
 */

@RestController
@RequestMapping("employee")
public class Employee {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employePojo) {
		return employeeService.createEmployee(employePojo);
	}

	@GetMapping("/all")
	public List<EmployeeEntity> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public EmployeeEntity getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/status/{status}")
	public List<EmployeeEntity> getEmployeeByStatus(@PathVariable String status) {
		return employeeService.getEmployeeByStatus(status);
	}
}
