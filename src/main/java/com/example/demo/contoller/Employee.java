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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enumeration.Status;
import com.example.demo.exception.EntityValidationException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This controller is used for CRUD operations in employee table.
 */

@RestController
@RequestMapping("employee")
@Api(value = "EmployeeController", description = "REST Apis related to Employee Entity")
public class Employee {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
    @ApiOperation("Create employee with unique email")
	public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity,BindingResult errors){
		 if(errors.hasErrors()){ 
			 throw new EntityValidationException(errors); 
		  }
		EmployeeEntity responseEmployee = employeeService.createEmployee(employeeEntity);
		return new ResponseEntity<String>("Employee created successfully with Id"+responseEmployee.getEmployeeId(),HttpStatus.CREATED);
	}

	@GetMapping("/all")
	@ApiOperation("Get all employees frm Db")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeEntity>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/all/byPage")
	@ApiOperation("get All employees with pagination and sortby applied, if no query param provided by defaulf pagenum=0,pagesize=10,sortby=employeeId")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployeeByPageniationAndsort(@RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "employeeId") String sortyBy) {
		return new ResponseEntity<List<EmployeeEntity>>(employeeService.getAllEmployeeByPageniationAndsort(pageNumber,pageSize,sortyBy),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation("Get employee details by id")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
		return new ResponseEntity<EmployeeEntity>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}

	@GetMapping("/status/{status}")
	@ApiOperation("Get employee details by status")
	public ResponseEntity<List<EmployeeEntity>> getEmployeeByStatus(@PathVariable Status status) {
		return new ResponseEntity<List<EmployeeEntity>>(employeeService.getEmployeeByStatus(status),HttpStatus.OK);
	}
}
