package com.employee.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.portal.dao.EmployeeDao;
import com.employee.portal.entity.Employee;
import com.employee.potal.service.EmployeeService;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	int count;

	@Override
	public void SaveEmployeeDetails(Employee employee) {
		employee.setEmployeeId(++count);
		employeeDao.SaveEmployeeDetails(employee);
	}

	@Override
	public List<Employee> getEmployeeDetails() {
		return employeeDao.getEmployeeDetails();
	}

	@Override
	public List<Employee> getUpdateDetails(Integer employeeId) {
		return employeeDao.getUpdateDetails(employeeId);
	}

	@Override
	public void getDeleteDetails(Integer employeeId) {
		employeeDao.getDeleteDetails(employeeId);
	}

	@Override
	public void UpdateEmployeeDetails(Employee employee, int employeeId) {
		employeeDao.UpdateEmployeeDetails(employee, employeeId);
	}

	@Override
	public List<Employee> getSearchEmployeeDetails(String name) {
		return employeeDao.getSearchEmployeeDetails(name);
	}

}
