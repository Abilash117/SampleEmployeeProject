package com.example.demo.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ProjectEntity;
import com.example.demo.service.ProjectService;

/**
 * This controller is used for CRUD operations in project table.
 */

@RestController
@RequestMapping("/project")
public class Project {
	@Autowired
	ProjectService projectService;

	@PostMapping("/create")
	public ProjectEntity createProject(@RequestBody ProjectEntity project) {
		ProjectEntity pojo = projectService.createProject(project);
		return pojo;
	}
	
	@GetMapping("/all")
	public List<ProjectEntity> getAllProject(){
		return projectService.getAllproject();	
	}
	
	@GetMapping("/{id}")
	public ProjectEntity getprojectById(@PathVariable Integer id){
		return projectService.getProjectById(id);
		
	}
}
