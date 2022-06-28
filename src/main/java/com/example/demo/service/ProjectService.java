package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.EntityExistsNotExistsException;
import com.example.demo.model.ProjectEntity;
import com.example.demo.repository.ProjectRepository;
@Component
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public ProjectEntity createProject(ProjectEntity projectPojo) {
		
		ProjectEntity project = projectRepository.save(projectPojo);
		return project;
	}

	public List<ProjectEntity> getAllproject() {
		return projectRepository.findAll();
	}

	public ProjectEntity getProjectById(Integer ProjectId) {
		Optional<ProjectEntity> optional = projectRepository.findById(ProjectId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
		  throw new EntityExistsNotExistsException("Project is not available with projectId="+ProjectId,1);
		}
	}

}
