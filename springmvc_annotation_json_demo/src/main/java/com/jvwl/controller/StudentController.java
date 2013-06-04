package com.jvwl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvwl.model.Student;

@Controller
@RequestMapping("content/student")
public class StudentController extends BaseController {
	@RequestMapping("add")
	public String add() {
		log.info("studentController add method invoke demo");
		return "student/add";
	}

	@RequestMapping("save")
	@ResponseBody
	public String save(@RequestBody Student student) {
		log.info(" save method invoking");
		log.info(student);
		return "保存成功！";
	}

	@RequestMapping("toList")
	public String toList() {
		return "student/list";
	}

	@RequestMapping("list")
	@ResponseBody
	public List<Student> list() {
		log.info(" list method invoking ");
		List<Student> students = new ArrayList<Student>();
		for (int i = 1; i < 10; i++) {
			Student student = new Student();
			student.setStu_no("stu_no" + i);
			student.setStu_name("stuName" + i);
			students.add(student);
		}
		return students;
	}
}
