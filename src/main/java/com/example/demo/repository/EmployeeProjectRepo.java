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

	@Transactional
	@Modifying
	@Query("Update EmployeeProjectEntity e set e.endDate=?1,e.status='completed' where e.employeeEntity =?2 and e.projectEntity=?3")
	public Integer updateEmployeeProject(String endDate, EmployeeEntity employeeId, ProjectEntity projectId);

}
