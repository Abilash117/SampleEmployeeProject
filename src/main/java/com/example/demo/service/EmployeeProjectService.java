package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.EmployeeProjectEntity;
import com.example.demo.repository.EmployeeProjectRepo;


@Component
public class EmployeeProjectService {
	@Autowired
	EmployeeProjectRepo employeeProjectRepo;

	public EmployeeProjectEntity createEmployeeProject(EmployeeProjectEntity employeeProject) {
		return employeeProjectRepo.save(employeeProject);
	}
	
	public EmployeeProjectEntity updateEmployeeProject(EmployeeProjectEntity emplProjectEntity) {
		return employeeProjectRepo.save(emplProjectEntity);	
	 
	}
}
