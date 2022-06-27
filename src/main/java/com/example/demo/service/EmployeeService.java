package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeEntity createEmployee(EmployeeEntity employeePojo) {
		EmployeeEntity employee = employeeRepository.save(employeePojo);
		return employee;
	}

	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public EmployeeEntity getEmployeeById(Integer employeeId) {
		Optional<EmployeeEntity> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<EmployeeEntity> getEmployeeByStatus(String employeeStatus) {
		return employeeRepository.findByStatus(employeeStatus);
	}
}
