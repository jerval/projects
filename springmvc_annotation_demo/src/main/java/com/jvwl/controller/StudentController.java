package com.jvwl.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jvwl.model.Student;

@Controller
@RequestMapping("/content/student")
public class StudentController extends BaseController {
	@RequestMapping("/add")
	public String add() {
		log.info("studentController add method invoke demo");
		return "student/add";
	}

	@RequestMapping("/save")
	public ModelAndView save( Student student) {
		log.info(" save method invoking");
		log.info(student);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listPage", "list.do");
		mav.setViewName("student/saveSuccess");
		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		log.info(" list method invoking ");
		List<Student> students = new ArrayList<Student>();
		for (int i = 1; i < 10; i++) {
			Student student = new Student();
			student.setStu_no("stu_no" + i);
			student.setStu_name("stuName" + i);
			students.add(student);
		}
		ModelAndView mav = new ModelAndView();
		log.info(students);
		mav.addObject("students", students);
		mav.setViewName("student/list");
		return mav;
	}
	@RequestMapping(value="/test",method=RequestMethod.GET,params="update")
	//@ModelAttribute()
	public String test( @ModelAttribute("pet") String dd,@RequestParam(value="id",required=false) String id,@PathVariable String info,@PathVariable String msg) {
		log.info("studentController test method invoke demo");
		log.info("info:"+info);
		log.info("msg:"+msg);
		return "test";
	}

	@RequestMapping(value = "/handler", method = RequestMethod.POST)
	public void handle(@RequestBody String body, Writer writer) throws IOException {
		log.info("studentController handle method invoke demo");
	  writer.write(body);
	}
	
}
