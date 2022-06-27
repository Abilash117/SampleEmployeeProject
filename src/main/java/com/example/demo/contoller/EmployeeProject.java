package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.EmployeeProjectEntity;
import com.example.demo.service.EmployeeProjectService;
/**
 * This controller is used for CRUD operations in employee-project table.
 */
@RestController
@RequestMapping("employee-project")
public class EmployeeProject {
	@Autowired
	EmployeeProjectService employeeProjectService;

	@PostMapping("/create")
	public EmployeeProjectEntity createEmployeeProject(@RequestBody EmployeeProjectEntity employee_project) {
		return employeeProjectService.createEmployeeProject(employee_project);
	}
	
	@PutMapping("/update")
	public int updateEmployeeProject(@RequestBody EmployeeProjectEntity employee_project) {
	return employeeProjectService.updateEmployeeProject(employee_project);
	
	}
}
