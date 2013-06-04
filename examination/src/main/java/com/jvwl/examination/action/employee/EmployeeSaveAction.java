package com.jvwl.examination.action.employee;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.service.IDepartmentService;
import com.jvwl.examination.service.IEmployeeService;
import com.jvwl.examination.util.MD5;
import com.opensymphony.xwork2.ModelDriven;

@Component("employeeSaveAction")
@SuppressWarnings("serial")
public class EmployeeSaveAction extends BaseAction implements
		ModelDriven<Employee> {

	private IEmployeeService<Employee> employeeService;
	private IDepartmentService<Department> departmentService;
	private Employee employee = new Employee();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setDepartmentService(
			IDepartmentService<Department> departmentService) {
		this.departmentService = departmentService;
	}

	@Resource
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String editSave() throws Exception {
		try {
			Department dep = departmentService.findClass(Department.class,
					employee.getDepartment().getId());
			if (dep == null) {
				throw new BusinessException(
						"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			Employee emp = employeeService.findClass(Employee.class, employee
					.getId());
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
			if (password != null && "".equals(password)) {
				emp.setPassword(new MD5().getMD5ofStr(employee.getPassword()));
			}
			employeeService.update(emp);
			message = new Message("修改员工信息成功！", true, "employee_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("修改员工信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String addSave() throws Exception {
		try {
			Department dep = departmentService.findClass(Department.class,
					employee.getDepartment().getId());
			if (dep == null) {
				throw new BusinessException(
						"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			employee.setDepartment(dep);
			employee.setPassword(new MD5().getMD5ofStr(employee.getPassword()));
			employeeService.save(employee);
			message = new Message("添加员工信息成功！", true, "employee_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("添加员工信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public Employee getModel() {
		return employee;
	}
}
