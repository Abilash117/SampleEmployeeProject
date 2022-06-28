package com.example.demo.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.EmployeeProjectEntity;
import com.example.demo.model.ProjectEntity;

/**
 * This is repository class project_employee table.
 */

@Repository
public interface EmployeeProjectRepo extends JpaRepository<EmployeeProjectEntity, Integer> {

}
