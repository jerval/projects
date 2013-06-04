package com.jvwl.test.action.manage.student;

import java.sql.SQLException;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Student;
import com.jvwl.test.service.StudentService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.ConversionType;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

@Results( { @Result(name = "success", location = "/message.jsp"),
		@Result(name = "invalid.token", location = "/invalid_token.jsp") })
@InterceptorRefs( { @InterceptorRef("checkStack"), @InterceptorRef("token") })
@Conversion()
@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Student> {

	private Student student = new Student();
	private StudentService studentService = new StudentService();

	@Override
	@TypeConversion(type = ConversionType.APPLICATION, converter = "com.jvwl.test.converter.DateConvertor")
	public String execute() throws Exception {
		if (student.getId() == null) {
			try {
				studentService.add(student);
			} catch (SQLException e) {
				return "add";
			}
		} else {
			try {
				studentService.update(student);
			} catch (SQLException e) {
				return "update";
			}
		}
		addActionMessage("学生信息操作成功！");
		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public Student getModel() {
		return student;
	}
}
