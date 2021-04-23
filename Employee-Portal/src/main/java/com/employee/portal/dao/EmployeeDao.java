package com.employee.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.portal.entity.Employee;

@Repository
public interface EmployeeDao {

	void SaveEmployeeDetails(Employee employee);

	List<Employee> getEmployeeDetails();

	List<Employee> getUpdateDetails(Integer employeeId);

	void getDeleteDetails(Integer employeeId);

	void UpdateEmployeeDetails(Employee employee, int employeeId);

	List<Employee> getSearchEmployeeDetails(String name);

}
