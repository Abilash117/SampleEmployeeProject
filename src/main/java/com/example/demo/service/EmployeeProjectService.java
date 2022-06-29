package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.enumeration.Status;
import com.example.demo.exception.EntityExistsNotExistsException;
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
		Optional<EmployeeProjectEntity> responseEmployeeProjectEntity = employeeProjectRepo.findById(emplProjectEntity.getId());
		EmployeeProjectEntity entity = new EmployeeProjectEntity();
		if (responseEmployeeProjectEntity.isPresent()) {
			entity = responseEmployeeProjectEntity.get();
			entity.setEndDate(emplProjectEntity.getEndDate());
			entity.setStatus(Status.COMPLETED);
		} else {
			throw new EntityExistsNotExistsException("Cannot update as id is not available in db", 1);
		}
		return employeeProjectRepo.save(entity);
	}

}
