package com.jvwl.action.department;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;

import com.jvwl.action.BaseAction;
import com.jvwl.dto.Message;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EditAction extends BaseAction implements
		ModelDriven<Department> {

	private DepartmentService departmentService = new DepartmentService();
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

	@JSON(serialize = false)
	@Action("update")
	public String update() throws Exception {
		department = departmentService.findClass(Department.class, department
				.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("delete")
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
			message = new Message(getText("operate_ok"),"删除数据成功！", true, null);
		} else {
			message = new Message(getText("operate_fail"),"删除数据失败！！！\n部分数据删除时发生异常", false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Department getModel() {
		return department;
	}
}
