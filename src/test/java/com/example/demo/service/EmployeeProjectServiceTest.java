package com.example.demo.service;

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
import com.example.demo.repository.EmployeeProjectRepo;

@SpringBootTest
public class EmployeeProjectServiceTest {
@Mock
EmployeeProjectRepo employeeProjectRepo;

@Test
public void createEmployeeProject() {
	EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity();
	EmployeeEntity employeePojo  = new EmployeeEntity();
	employeePojo.setEmployeeId(1);
	ProjectEntity projectBean = new ProjectEntity();
	projectBean.setProjectId(1);
	projectBean.setProjectName("agnipath");
	employeeProjectEntity.setEmployeeEntity(employeePojo);
	employeeProjectEntity.setProjectEntity(projectBean);
	//stubbing the values
	when(employeeProjectRepo.save(ArgumentMatchers.any(EmployeeProjectEntity.class))).thenReturn(employeeProjectEntity);
	EmployeeProjectEntity returnEmployeeProjectEntity = employeeProjectRepo.save(employeeProjectEntity);
	//checking the values
	assertEquals(returnEmployeeProjectEntity.getEmployeeEntity().getEmployeeId(), 1);
	//verify save is called or not
	verify(employeeProjectRepo).save(employeeProjectEntity);
}

@Test
public void udateEmployeeProject() {
	EmployeeProjectEntity employeeProjectEntity = new EmployeeProjectEntity();
	EmployeeEntity employeePojo  = new EmployeeEntity();
	employeePojo.setEmployeeId(1);
	ProjectEntity projectBean = new ProjectEntity();
	projectBean.setProjectId(1);
	projectBean.setProjectName("agnipath");
	employeeProjectEntity.setEmployeeEntity(employeePojo);
	employeeProjectEntity.setProjectEntity(projectBean);
	//stubbing the values
	when(employeeProjectRepo.save(employeeProjectEntity)).thenReturn(employeeProjectEntity);
	EmployeeProjectEntity returnEmployeeProjectEntity = employeeProjectRepo.save(employeeProjectEntity);
	//checking the values
	assertEquals(returnEmployeeProjectEntity.getEmployeeEntity().getEmployeeId(), 1);
	//verfiy updateEmployeeProject is called or not
	verify(employeeProjectRepo).save(employeeProjectEntity);
}


}
