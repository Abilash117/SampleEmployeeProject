package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.enumeration.Status;
import com.example.demo.exception.EntityExistsNotExistsException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@SpringBootTest
public class EmployeeTestController {

	@Mock
	EmployeeService employeService;
	@Autowired
	Validator validator;

	@Test
	public void createEmployee() {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		// stubing the values
		Mockito.when(employeService.createEmployee(ArgumentMatchers.any(EmployeeEntity.class)))
				.thenReturn(employeePojo);
		EmployeeEntity empoEntity = employeService.createEmployee(employeePojo);
		// checking for condition
		assertEquals(1, empoEntity.getEmployeeId());
		// verifying whether this service is called.
		Mockito.verify(employeService).createEmployee(employeePojo);
	}

	/**
	 * Test case for valid employeename field.
	 */
	@Test
	public void createEmployeeCaseTwo() {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		employeePojo.setStatus(Status.ACTIVE);
		employeePojo.setEmployeeName("ddd-d");
		employeePojo.setDesignation("dd");
		Set<ConstraintViolation<EmployeeEntity>> v = validator.validate(employeePojo);
		ConstraintViolation<EmployeeEntity> violation = v.iterator().next();
		// stubing the values
		assertEquals("EmployeeName should contain only character", violation.getMessage());

	}

	@Test
	public void getAllEmployeeByPageniationAndsort() {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		EmployeeEntity employeePojo2 = new EmployeeEntity();
		employeePojo2.setEmployeeId(2);
		List<EmployeeEntity> list = new ArrayList<>();
		list.add(employeePojo);
		list.add(employeePojo2);
		// stubing the values
		Mockito.when(employeService.getAllEmployeeByPageniationAndsort(1, 10, "employeeName")).thenReturn(list);
		List<EmployeeEntity> empEntityList = employeService.getAllEmployeeByPageniationAndsort(1, 10, "employeeName");
		// checking for condition
		assertTrue(empEntityList.size() > 0);
		// verifying whether this service is called.
		Mockito.verify(employeService).getAllEmployeeByPageniationAndsort(1, 10, "employeeName");
	}

	@Test
	public void getAllEmployee() {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		EmployeeEntity employeePojo2 = new EmployeeEntity();
		employeePojo2.setEmployeeId(2);
		List<EmployeeEntity> list = new ArrayList<>();
		list.add(employeePojo);
		list.add(employeePojo2);
		// stubing the values
		Mockito.when(employeService.getAllEmployee()).thenReturn(list);
		List<EmployeeEntity> empEntityList = employeService.getAllEmployee();
		// checking for condition
		assertTrue(empEntityList.size() > 0);
		// verifying whether this service is called.
		Mockito.verify(employeService).getAllEmployee();
	}

	@Test
	public void getEmployeeByIdExceptionScenario()  {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(100);
        // stubing the values
        Mockito.when(employeService.getEmployeeById(100))
				.thenThrow(new EntityExistsNotExistsException("employee is not available with given id", 0));
		EntityExistsNotExistsException exception = assertThrows(EntityExistsNotExistsException.class, () -> {
			employeService.getEmployeeById(100);
		});
		assertEquals("employee is not available with given id", exception.getErrorMessage());

		// verifying whether this service is called.
		Mockito.verify(employeService).getEmployeeById(100);
	}

	@Test
	public void getEmployeeByStatus() {
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		employeePojo.setStatus(Status.DE_ACTIVE);
		EmployeeEntity employeePojo2 = new EmployeeEntity();
		employeePojo2.setEmployeeId(2);
		employeePojo2.setStatus(Status.ACTIVE);

		List<EmployeeEntity> list = new ArrayList<>();
		list.add(employeePojo);
		list.add(employeePojo2);

		// stubing the values
		Mockito.when(employeService.getEmployeeByStatus(ArgumentMatchers.any(Status.class))).thenReturn(list);
		List<EmployeeEntity> empEntityList = employeService.getEmployeeByStatus(Status.ACTIVE);
		// checking for condition
		assertThat(empEntityList.size() > 0);
		// verifying whether this service is called.
		Mockito.verify(employeService).getEmployeeByStatus(Status.ACTIVE);
	}

}
