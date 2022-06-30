package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EmployeeProjectEntity;


/**
 * This is repository class project_employee table.
 */

@Repository
public interface EmployeeProjectRepo extends JpaRepository<EmployeeProjectEntity, Integer> {

}
