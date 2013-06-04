package com.jvwl.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jerval
 * @date 2011-9-20
 */
@Controller
@RequestMapping("portfolio")
public class PortfolioAction  {

	//@RequestMapping(params = "method=addUser") 
	@RequestMapping("add")
	public void addUser(String username,HttpServletResponse response) {
		System.out.println(username+":::");
//		JSONObject json = new JSONObject();
//		try {
//			json.put("username", "雷武銮");
//			json.put("age", 22);
//			this.outJsonString(response, json.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
	@RequestMapping(value="find",method=RequestMethod.GET)
	public String find() {
		System.out.println("aaaa");return "bbb";
	}
}
