package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.ProjectEntity;
import com.example.demo.service.ProjectService;

@SpringBootTest
public class ProjectTest {

	@Mock
	ProjectService projectService;

	@Test
	public void createProject() {
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectId(1);
		// stubbing the values
		when(projectService.createProject(ArgumentMatchers.any(ProjectEntity.class))).thenReturn(projectEntity);
		ProjectEntity newpProjectEntity = projectService.createProject(projectEntity);
		// check for assert equals
		assertEquals(newpProjectEntity.getProjectId(), 1);
		// verify the method is called or not
		Mockito.verify(projectService).createProject(projectEntity);
	}

	@Test
	public void getAllproject() {
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");
		ProjectEntity projectBeans = new ProjectEntity();
		projectBean.setProjectId(2);
		projectBean.setProjectName("agnipath2");

		List<ProjectEntity> listOfEntity = new ArrayList<>();
		listOfEntity.add(projectBean);
		listOfEntity.add(projectBeans);

		// Stubbing the values
		Mockito.when(projectService.getAllproject()).thenReturn(listOfEntity);
		List<ProjectEntity> listOfProjects = projectService.getAllproject();

		// check for assert equals
		assertTrue(listOfProjects.size() > 1);
		// verify the method is called or not
		Mockito.verify(projectService).getAllproject();
	}

	@Test
	public void getProjectById() {
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");

		// Stubbing the values
		Mockito.when(projectService.getProjectById(ArgumentMatchers.any(Integer.class))).thenReturn(projectBean);
		ProjectEntity returnValue = projectService.getProjectById(1);
		// check for assert equals
		assertEquals(returnValue.getProjectId(), 1);
		// verify the method is called or not
		Mockito.verify(projectService).getProjectById(1);
	}
}
