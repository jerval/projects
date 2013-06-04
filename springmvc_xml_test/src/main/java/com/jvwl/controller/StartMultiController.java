package com.jvwl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.jvwl.model.User;

public class StartMultiController extends MultiActionController {

	public ModelAndView toLogin(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login1");
		mav.addObject("types",new String[]{"user","admin"} );
		return mav;
	}
	
	public String login1(HttpServletRequest request,
			HttpServletResponse response,User user){
		System.out.println(user);
		return "success";
	}
	
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
