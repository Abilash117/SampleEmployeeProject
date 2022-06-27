package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ProjectEntity;

/**
 * This class is repository class project_employee table.
 */

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer>{

}
