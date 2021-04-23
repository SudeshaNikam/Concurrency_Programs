package com.employee.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.portal.entity.Employee;
import com.employee.potal.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		Employee emp = new Employee();
		model.addAttribute(emp);
		model.addAttribute("btnValue", "Save");
		return "employeeForm";

	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee) {
		List<Employee> employeeList = employeeService.getEmployeeDetails();
		boolean Exists = false;
		for (Employee employee2 : employeeList) {
			if (employee2.getEmployeeId() == employee.getEmployeeId()) {
				System.out.println("employee" + employee.getEmployeeId());
				Exists = true;
			}
		}
		if (Exists) {
			employeeService.UpdateEmployeeDetails(employee, employee.getEmployeeId());
		} else {
			employeeService.SaveEmployeeDetails(employee);
		}
		return "redirect:/getEmployeeDetails";
	}

	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
	public String getEmployeesDetails(Model model) {
		List<Employee> employeeList = employeeService.getEmployeeDetails();
		model.addAttribute("employeeList", employeeList);
		System.out.println("details>>>>>>>>>>>>>" + employeeList);
		model.addAttribute("message", "Saved Employee Details Successfully");
		model.addAttribute("employeeList", employeeList);
		return "employeeList";
	}

	@RequestMapping(value = "/updateEmplyeeDetails", method = RequestMethod.GET)
	public String updateEmplyeeDetails(@RequestParam int employeeId, Model model, @ModelAttribute Employee employee) {
		System.out.println("update dedtails");
		List<Employee> employeeList = employeeService.getUpdateDetails(employeeId);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("btnValue", "Update");
		return "employeeForm";
	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int employeeId, Model model) {
		System.out.println("employee " + employeeId);
		employeeService.getDeleteDetails(employeeId);
		List<Employee> employeeList = employeeService.getEmployeeDetails();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("message", "Delete Employee Details Successfully");
		return "employeeList";
	}

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam String name, Model model) {
		System.out.println("employee " + name);
		List<Employee> employeeList = employeeService.getSearchEmployeeDetails(name);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("message", "Search Employee  Details");
		return "employeeList";
	}

}
