package com.jvwl.test.action.manage.student;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Student;
import com.jvwl.test.service.StudentService;

@SuppressWarnings("serial")
public class EditAction extends BaseAction {

	private StudentService studentService = new StudentService();
	private Student student;
	private Integer id;
	
	public Student getStudent() {
		return student;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Action("add")
	public String add() throws Exception {
		return SUCCESS;
	}

	@Action("update")
	public String update() throws Exception {
		student = studentService.findStudentById(id);
		return SUCCESS;
	}

	@Action(value="delete",results={@Result(name = "success", location = "/message.jsp")})
	public String delete() throws Exception {
		studentService.delete(id);
		addActionMessage("删除成功");
		return SUCCESS;
	}

}
