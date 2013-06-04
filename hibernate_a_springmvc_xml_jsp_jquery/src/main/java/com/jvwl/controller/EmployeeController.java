package com.jvwl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.model.Employee;
import com.jvwl.service.DepartmentService;
import com.jvwl.service.EmployeeService;

public class EmployeeController extends BaseController {

	private EmployeeService employeeService = new EmployeeService();
	private DepartmentService departmentService = new DepartmentService();

	public String add(HttpServletRequest request, HttpServletResponse response) {
		log.info("add method in employeeController ");
		return "employee/add";
	}

	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response, String id) {
		log.info(" EmployeeController save invoke");
		log.info(id);
		Employee employee = employeeService.findClass(id);
		List<Department> departments = departmentService.findDepartments();
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", employee);
		mav.addObject("departments", departments);
		mav.setViewName("employee/update");
		return mav;
	}

	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, String[] ids) {
		log.info(" EmployeeController save invoke");
		log.info("ids lenth:" + ids.length);
		try {
			employeeService.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response, Employee employee) {
		log.info(" EmployeeController save invoke");
		log.info(employee);
		if (employee.getId() == null) {
			try {
				Department dep = departmentService.findClass(employee
						.getDepartment().getId());
				if (dep == null) {
					throw new BusinessException(
							"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
				}
				employee.setDepartment(dep);
				employee.setPassword(employee.getPassword());
				employeeService.add(employee);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Department dep = departmentService.findClass(employee
						.getDepartment().getId());
				if (dep == null) {
					throw new BusinessException(
							"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
				}
				Employee emp = employeeService.findClass(employee.getId());
				emp.setEmp_id(employee.getEmp_id());
				emp.setEmp_name(employee.getEmp_name());
				emp.setGender(employee.getGender());
				emp.setDepartment(dep);
				emp.setVersion(employee.getVersion());
				emp.setLevel(employee.getLevel());
				emp.setBirthday(employee.getBirthday());
				emp.setPhone(employee.getPhone());
				emp.setEmail(employee.getEmail());
				emp.setAddress(employee.getAddress());
				emp.setContact(emp.getContact());
				emp.setMemo(employee.getMemo());
				emp.setDep_manager(employee.getDep_manager());
				String password = employee.getPassword();
				if (password != null && !"".equals(password)) {
					emp.setPassword(employee.getPassword());
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
