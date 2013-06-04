package com.jvwl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.jvwl.dto.PageInfo;
import com.jvwl.dto.Pagination;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;

public class DepartmentController extends BaseController {
	private DepartmentService departmentService = new DepartmentService();

	public String add(HttpServletRequest request, HttpServletResponse response) {
		log.info("add method in departmentController ");
		return "department/add";
	}

	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response, String id) {
		log.info(" DepartmentController save invoke");
		log.info(id);
		Department department = departmentService.findClass(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("department", department);
		mav.setViewName("department/update");
		return mav;
	}

	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, String[] ids) {
		log.info(" DepartmentController save invoke");
		log.info("ids lenth:" + ids.length);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		try {
			departmentService.delete(ids);
			mav.addObject("message", "删除部门信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "删除部门信息失败！");
			mav.addObject("reason",e.getMessage());
		}
		return mav;
	}

	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response, Department department) {
		log.info(" DepartmentController save invoke");
		log.info(department);
		ModelAndView mav = new ModelAndView();
		if (department.getId() == null) {
			try {
				departmentService.add(department);
				mav.addObject("message", "添加部门信息成功！");
				mav.addObject("toUrl", "department.do?func=list");
			} catch (BusinessException e) {
				e.printStackTrace();
				mav.addObject("message", "添加部门信息失败！");
				mav.addObject("reason",e.getMessage());
				mav.addObject("toUrl", "department.do?func=add");
			}
		} else {
			try {
				Department dep = departmentService
						.findClass(department.getId());
				dep.setDepart_id(department.getDepart_id());
				dep.setDepart_name(department.getDepart_name());
				dep.setDepart_info(department.getDepart_info());
				dep.setVersion(department.getVersion());
				departmentService.update(dep);
				mav.addObject("message", "修改部门信息成功！");
			} catch (BusinessException e) {
				e.printStackTrace();
				mav.addObject("message", "修改部门信息失败！");
				mav.addObject("reason",e.getMessage());
				
			}
		}
		return mav;
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) {
		Pagination<Department> pagination = departmentService.findDepartments(null, new PageInfo(1, 999999));
		ModelAndView mav = new ModelAndView();
		mav.addObject("pagination", pagination);
		mav.setViewName("department/list");
		return mav;
	}
}
