package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<EmployeeProjectEntity> createEmployeeProject(@RequestBody EmployeeProjectEntity employee_project) {
		return new ResponseEntity<EmployeeProjectEntity>(employeeProjectService.createEmployeeProject(employee_project),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeProjectEntity> updateEmployeeProject(@RequestBody EmployeeProjectEntity employee_project) {
	return new ResponseEntity<EmployeeProjectEntity>(employeeProjectService.updateEmployeeProject(employee_project),HttpStatus.OK);
	
	}
}
