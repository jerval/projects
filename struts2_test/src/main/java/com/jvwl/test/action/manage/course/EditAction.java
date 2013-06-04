package com.jvwl.test.action.manage.course;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Course;
import com.jvwl.test.service.CourseService;

@SuppressWarnings("serial")
public class EditAction extends BaseAction {

	private CourseService courseService = new CourseService();
	private Course course;
	private Integer id;
	
	public Course getCourse() {
		return course;
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
		course = courseService.findCourseById(id);
		return SUCCESS;
	}

	@Action(value="delete",results={@Result(name = "success", location = "/message.jsp")})
	public String delete() throws Exception {
		courseService.delete(id);
		addActionMessage("删除成功");
		return SUCCESS;
	}
	
	public Course getModel() {
		return course;
	}
}
