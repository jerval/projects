package com.jvwl.test.action.manage.course;

import java.sql.SQLException;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Course;
import com.jvwl.test.service.CourseService;
import com.opensymphony.xwork2.ModelDriven;

@Results( { @Result(name = "success", location = "/message.jsp"),
		@Result(name = "invalid.token", location = "/invalid_token.jsp") })
@InterceptorRefs( { @InterceptorRef("checkStack"), @InterceptorRef("token") })
@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Course> {

	private Course course = new Course();
	private CourseService courseService = new CourseService();

	@Override
	public String execute() throws Exception {
		if (course.getId() == null) {
			try {
				courseService.add(course);
			} catch (SQLException e) {
				return "add";
			}

		} else {
			try {
				courseService.update(course);
			} catch (SQLException e) {
				return "update";
			}
		}
		addActionMessage("课程信息操作成功！");
		return SUCCESS;
	}

	public Course getCourse() {
		return course;
	}

	public Course getModel() {
		return course;
	}
}
