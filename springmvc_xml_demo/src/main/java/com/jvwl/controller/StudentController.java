package com.jvwl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.jvwl.model.Student;

public class StudentController extends BaseController {

	public String add(HttpServletRequest request, HttpServletResponse response) {
		log.info("studentController add method invoke ");
		return "student/add";
	}

	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response, Student student) {
		log.info(" save method invoking ");
		log.info(student);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listPage",  "student.do?func=list");
		mav.setViewName("student/saveSuccess");
		return mav;
	}
	
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		log.info(" list method invoking ");
		List<Student> students = new ArrayList<Student>();
		for(int i=1;i<10;i++){
			Student student = new Student();
			student.setStu_no("stu_no"+i);
			student.setStu_name("stuName"+i);
			students.add(student);
		}
		ModelAndView mav = new ModelAndView();
		log.info(students);
		mav.addObject("students",  students);
		mav.setViewName("student/list");
		return mav;
	}
}
