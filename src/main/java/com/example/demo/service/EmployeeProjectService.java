package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.EmployeeProjectEntity;
import com.example.demo.repository.EmployeeProjectRepo;


@Component
public class EmployeeProjectService {
	@Autowired
	EmployeeProjectRepo employeeProjectRepo;

	public EmployeeProjectEntity createEmployeeProject(EmployeeProjectEntity employee_Project) {
		return employeeProjectRepo.save(employee_Project);
	}
	
	public int updateEmployeeProject(EmployeeProjectEntity emplProjectEntity) {
		String endDate = emplProjectEntity.getEndDate();
		return employeeProjectRepo.updateEmployeeProject(endDate,emplProjectEntity.getEmployeeEntity(),emplProjectEntity.getProjectEntity());	
	 
	}
}
