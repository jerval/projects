package com.jvwl.examination.action.department;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.service.IDepartmentService;
import com.opensymphony.xwork2.ModelDriven;

@Component("departmentSaveAction")
@SuppressWarnings("serial")
public class DepartmentSaveAction extends BaseAction implements
		ModelDriven<Department> {

	private IDepartmentService<Department> departmentService;
	private Department department = new Department();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setDepartmentService(
			IDepartmentService<Department> departmentService) {
		this.departmentService = departmentService;
	}
	
	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize=false)
	public String addSave() throws Exception {
		try {
			departmentService.save(department);
			message = new Message("添加部门信息成功！", true,"department_list.html");
		} catch (BusinessException e) {
			e.printStackTrace();
			message = new Message("添加部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public String editSave() throws Exception {
		try {
			Department dep = departmentService.findClass(Department.class,
					department.getId());
			dep.setDepart_id(department.getDepart_id());
			dep.setDepart_name(department.getDepart_name());
			dep.setDepart_info(department.getDepart_info());
			dep.setVersion(department.getVersion());
			departmentService.update(dep);
			message = new Message("修改部门信息成功！", true,"department_list.html");
		} catch (BusinessException e) {
			e.printStackTrace();
			message = new Message("修改部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize=false)
	public Department getModel() {
		return department;
	}
}
