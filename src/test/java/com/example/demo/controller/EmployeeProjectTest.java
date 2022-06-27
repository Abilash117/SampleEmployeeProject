package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeProjectEntity;
import com.example.demo.model.ProjectEntity;
import com.example.demo.service.EmployeeProjectService;

@SpringBootTest
public class EmployeeProjectTest {

	@Mock
	EmployeeProjectService employeeProjectService;

	@Test
	public void createEmployeeProject() {
		EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity();
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");
		employeeProjectEntity.setEmployeeEntity(employeePojo);
		employeeProjectEntity.setProjectEntity(projectBean);
		// stubbing the values
		when(employeeProjectService.createEmployeeProject(ArgumentMatchers.any(EmployeeProjectEntity.class))).thenReturn(employeeProjectEntity);

		EmployeeProjectEntity returnEmployeeProjectEntity = employeeProjectService.createEmployeeProject(employeeProjectEntity);
		// check for the values
		assertEquals(returnEmployeeProjectEntity.getEmployeeEntity().getEmployeeId(), 1);
		// verify createEmployeeProject is called or not
		verify(employeeProjectService).createEmployeeProject(employeeProjectEntity);

	}

	@Test
	public void udateEmployeeProject() {
		EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity();
		EmployeeEntity employeePojo = new EmployeeEntity();
		employeePojo.setEmployeeId(1);
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");
		employeeProjectEntity.setEmployeeEntity(employeePojo);
		employeeProjectEntity.setProjectEntity(projectBean);
		// stubbing the values
		when(employeeProjectService.updateEmployeeProject(ArgumentMatchers.any(EmployeeProjectEntity.class))).thenReturn(1);
		Integer returnEmployeeProjectEntity = employeeProjectService.updateEmployeeProject(employeeProjectEntity);
		assertEquals(returnEmployeeProjectEntity, 1);
		// verify updateEmployeeProject is called or not
		verify(employeeProjectService).updateEmployeeProject(employeeProjectEntity);
	}

}
