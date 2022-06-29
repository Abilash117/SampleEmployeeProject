package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.demo.enumeration.Status;
import com.example.demo.exception.EntityExistsNotExistsException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeEntity createEmployee(EmployeeEntity employeePojo) {
		List<EmployeeEntity> employee = employeeRepository.findByEmailId(employeePojo.getEmailId());
		if (employee.size() > 0) {
			throw new EntityExistsNotExistsException(employeePojo.getEmailId() + " is already available", 1);
		}
		EmployeeEntity employeeEntity = employeeRepository.save(employeePojo);
		return employeeEntity;
	}

	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public List<EmployeeEntity> getAllEmployeeByPageniationAndsort(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<EmployeeEntity> pages = employeeRepository.findAll(page);
		return pages.getContent();
	}

	public EmployeeEntity getEmployeeById(Integer employeeId) {
		Optional<EmployeeEntity> optional = employeeRepository.findById(employeeId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityExistsNotExistsException("Employee not exists with employeeId " + employeeId, 1);

		}
	}

	public List<EmployeeEntity> getEmployeeByStatus(Status employeeStatus) {
		return employeeRepository.findByStatus(employeeStatus);
	}

	public List<EmployeeEntity> getEmployeeByEmail(String employeeEmail) {
		return employeeRepository.findByEmailId(employeeEmail);
	}

}
