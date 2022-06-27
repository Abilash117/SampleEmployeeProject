package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.ProjectEntity;
import com.example.demo.repository.ProjectRepository;

@SpringBootTest
public class ProjectServiceTest {
	@Mock
	ProjectRepository projectRepository;

	@Test
	public void createproject() {
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");
		// Stubbing the values
		Mockito.when(projectRepository.save(ArgumentMatchers.any(ProjectEntity.class))).thenReturn(projectBean);
		ProjectEntity returnValue = projectRepository.save(projectBean);
		// check for assert equals
		assertEquals(returnValue.getProjectId(), 1);
		// verify the method is called or not
		Mockito.verify(projectRepository).save(projectBean);
	}

	@Test
	public void getAllProject() {
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
		Mockito.when(projectRepository.findAll()).thenReturn(listOfEntity);
		List<ProjectEntity> listOfProjects = projectRepository.findAll();
		// check for assert equals
		assertTrue(listOfProjects.size() > 1);
		// verify the method is called or not
		Mockito.verify(projectRepository).findAll();
	}

	@Test
	public void getProjectById() {
		ProjectEntity projectBean = new ProjectEntity();
		projectBean.setProjectId(1);
		projectBean.setProjectName("agnipath");
		Optional<ProjectEntity> optional = Optional.ofNullable(projectBean);
		// Stubbing the values
		Mockito.when(projectRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(optional);
		Optional<ProjectEntity> returnValue = projectRepository.findById(1);
		// check for assert equals
		assertEquals(returnValue.isPresent(), true);
		// verify the method is called or not
		Mockito.verify(projectRepository).findById(1);
	}

}
