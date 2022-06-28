package com.example.demo.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.EntityValidationException;
import com.example.demo.model.ProjectEntity;
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This controller is used for CRUD operations in project table.
 */

@RestController
@RequestMapping("/project")
public class Project {
	@Autowired
	ProjectService projectService;

	@PostMapping("/create")
	public ResponseEntity createProject(@Valid @RequestBody ProjectEntity project,BindingResult errors) {
		if(errors.hasErrors()) {
			throw new EntityValidationException(errors);
		}
		ProjectEntity projectEntity = projectService.createProject(project);
		return new ResponseEntity(projectEntity,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProjectEntity>> getAllProject(){
		return new ResponseEntity<List<ProjectEntity>>(projectService.getAllproject(),HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ProjectEntity getprojectById(@PathVariable Integer id){
		return projectService.getProjectById(id);
		
	}
}
