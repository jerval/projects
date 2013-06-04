package com.jvwl.action;

import java.util.ArrayList;
import java.util.List;
import com.jvwl.model.Student;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewJasperReportAction extends ActionSupport {
	private List<Student> students =new ArrayList<Student>();

	@Override
	public String execute() throws Exception {
		Student student = new Student();
		for(int i=0;i<20;i++){
			student.setId(i);
			student.setAge((int) (Math.random()*100));
			student.setName("张买点的朋友");
			student.setAddress("四川省巴中市**地方");
			student.setStuNum((int) (Math.random()*10000000)+"");
			students.add(student);
		}
		return SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}
}
