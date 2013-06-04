package com.jvwl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvwl.dto.DepartmentDTO;
import com.jvwl.dto.Message;
import com.jvwl.dto.PageInfo;
import com.jvwl.dto.Pagination;
import com.jvwl.exception.BusinessException;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;

@Controller
@RequestMapping("system/manage/department")
public class DepartmentController extends BaseController {
	private DepartmentService departmentService = new DepartmentService();

	@RequestMapping("update")
	@ResponseBody
	public Department update(@RequestParam Integer id) {
		log.info(" DepartmentController save invoke");
		log.info(id);
		Department department = departmentService.findClass(id);
		log.info(department);
		return department;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message delete(@RequestParam Integer[] ids) {
		log.info(" DepartmentController save invoke");
		log.info("ids lenth:" + ids.length);
		Message message = null;
		try {
			departmentService.delete(ids);
			 message = new Message("操作成功", "删除部门信息成功！", true, "");
		} catch (Exception e) {
			e.printStackTrace();
			 message = new Message("操作失败", "删除部门信息失败！", false, "");
		}
		return message;
	}

	@RequestMapping("save")
	@ResponseBody
	public Message save(@RequestBody Department department) {
		log.info(" DepartmentController save invoke");
		log.info(department);
		Message message = null;
		if (department.getId() == -1) {
			try {
				department.setId(null);
				department.setVersion(null);
				departmentService.add(department);
				message = new Message("操作成功", "添加部门信息成功！", true,
						"list.html");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message("操作失败", "添加部门信息失败，请重试！<br/>原因："
						+ e.getMessage(), false, null);
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
				message = new Message("操作成功", "修改部门信息成功！", true,
						"list.html");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message("操作失败", "修改部门信息失败，请重试！<br/>原因："
						+ e.getMessage(), false, null);
			}
		}
		return message;
	}

	@RequestMapping("list/{pageNo}/{pageSize}")
	@ResponseBody
	public Pagination<Department> list(
			@RequestBody  DepartmentDTO departmentDTO,
			@PathVariable Integer pageNo, @PathVariable Integer pageSize,
			HttpSession session) {
		log.info("list invoke");
		log.info(departmentDTO);
		if (pageNo == null) {
			pageNo = 1;
		}
		if (session.getAttribute("pageSize") == null) {
			session.setAttribute("pageSize", 10);
			pageSize = 10;
		} else if (pageSize != null) {
			session.setAttribute("pageSize", pageSize);
		}

		Pagination<Department> pagination = departmentService.findDepartments(
				null, new PageInfo(1, 10));
		return pagination;
	}

}
