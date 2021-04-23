package com.employee.portal.entity;

public class Employee {

	private int employeeId;
	private String name;
	private String projectDetails;
	private String emailId;
	private String phoneNo;

	public Employee() {
	}

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public Employee(int employeeId, String name, String projectDetails, String emailId, String phoneNo) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.projectDetails = projectDetails;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name() {
		return projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", projectDetails=" + projectDetails
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
	}

}
