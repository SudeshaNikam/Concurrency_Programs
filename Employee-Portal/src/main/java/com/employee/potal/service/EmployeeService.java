package com.employee.potal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.portal.entity.Employee;

@Service
public interface EmployeeService {

	void SaveEmployeeDetails(Employee employee);

	List<Employee> getEmployeeDetails();

	List<Employee> getUpdateDetails(Integer employeeId);

	void getDeleteDetails(Integer employeeId);

	void UpdateEmployeeDetails(Employee employee, int employeeId);

	List<Employee> getSearchEmployeeDetails(String name);

}
