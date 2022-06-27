package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * This class is for managing employee table.
 */

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity implements Serializable {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name = "EMPLOYEE_NAME")
    private String employeeName;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NUM")
	private String mobileNum;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "CREATED_BY")
	private String creadtedBy;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreadtedBy() {
		return creadtedBy;
	}

	public void setCreadtedBy(String creadtedBy) {
		this.creadtedBy = creadtedBy;
	}
}
