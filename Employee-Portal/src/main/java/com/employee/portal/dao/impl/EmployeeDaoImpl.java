package com.employee.portal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.portal.ConectionManager;
import com.employee.portal.dao.EmployeeDao;
import com.employee.portal.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee> employeeList = new ArrayList<Employee>();
	Connection conn = ConectionManager.getConnection();
	Statement stmt = null;

	@Override
	public void SaveEmployeeDetails(Employee employee) {
		try {

			PreparedStatement stmt = conn.prepareStatement(
					"insert into Employee (employeeId, name, projectDetails, emailId,phoneNo) values (?,?,?,?,?)");
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getProjectDetails());
			stmt.setString(4, employee.getEmailId());
			stmt.setString(5, employee.getPhoneNo());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployeeDetails() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from Employee");
			while (result.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(result.getInt("EmployeeId"));
				emp.setName(result.getString("name"));
				emp.setProjectDetails(result.getString("projectDetails"));
				emp.setEmailId(result.getString("emailId"));
				emp.setPhoneNo(result.getString("phoneNo"));
				employeeList.add(emp);
			}
			return employeeList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Employee> getUpdateDetails(Integer employeeId) {

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			String QUERY = "select EmployeeId,name,projectDetails,emailId,phoneNo from Employee where employeeId ="
					+ employeeId + "";
			ResultSet result = conn.createStatement().executeQuery(QUERY);
			while (result.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(result.getInt("EmployeeId"));
				emp.setName(result.getString("name"));
				emp.setProjectDetails(result.getString("projectDetails"));
				emp.setEmailId(result.getString("emailId"));
				emp.setPhoneNo(result.getString("phoneNo"));
				employeeList.add(emp);
			}
			return employeeList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void getDeleteDetails(Integer employeeId) {
		try {
			stmt = conn.createStatement();
			stmt.execute("delete FROM Employee where EmployeeId =" + employeeId + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateEmployeeDetails(Employee employee, int employeeId) {
		System.out.println("" + employee.getName());
		System.out.println("" + employee.getProjectDetails());
		System.out.println("" + employee.getEmailId());
		System.out.println("" + employee.getPhoneNo());
		System.out.println("" + employeeId);
		try {
			stmt = conn.createStatement();
			String sql = "update Employee set name='" + employee.getName() + "', projectDetails='"
					+ employee.getProjectDetails() + "',emailId='" + employee.getEmailId() + "',phoneNo='"
					+ employee.getPhoneNo() + "' where employeeId=" + employeeId + "";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getSearchEmployeeDetails(String name) {
		try {
			List<Employee> employeeList1 = new ArrayList<Employee>();
			ResultSet result = conn.createStatement()
					.executeQuery("select * from Employee where name like '" + name + "' or projectDetails like '" + name + "' or emailId like '" + name + "' or phoneNo like '" + name + "'");
			System.out.println(result);
			while (result.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(result.getInt("EmployeeId"));
				emp.setName(result.getString("name"));
				emp.setProjectDetails(result.getString("projectDetails"));
				emp.setEmailId(result.getString("emailId"));
				emp.setPhoneNo(result.getString("phoneNo"));
				employeeList1.add(emp);
				System.out.println(employeeList);
			}
			return employeeList1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
