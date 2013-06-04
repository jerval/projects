package com.jvwl.examination.action.department;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.service.IDepartmentService;
import com.opensymphony.xwork2.ModelDriven;

@Component("departmentEditAction")
@SuppressWarnings("serial")
public class DepartmentEditAction extends BaseAction implements
		ModelDriven<Department> {

	private IDepartmentService<Department> departmentService;
	private Department department = new Department();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public Department getDepartment() {
		return department;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
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

	@JSON(serialize = false)
	public String update() throws Exception {
		department = departmentService.findClass(Department.class, department
				.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				departmentService.delete(departmentService.find(
						Department.class, Integer.parseInt(id)));
			} catch (Exception e) {
				state = false;
				e.printStackTrace();
			}
		}
		if (state) {
			message = new Message("删除数据成功！", true, null);
		} else {
			message = new Message("删除数据失败！！！\n部分数据删除时发生异常", false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public Department getModel() {
		return department;
	}
}
