package com.jvwl.test.action.manage.student;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Student;
import com.jvwl.test.service.StudentService;

@SuppressWarnings("serial")
public class ListAction extends BaseAction {

	private Pagination<Student> pagination;
	private StudentService studentService = new StudentService();
	private Integer pageNo;
	private Integer pageSize;

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Pagination<Student> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Student> pagination) {
		this.pagination = pagination;
	}

	@Override
	public String execute() throws Exception {
		if(pageNo==null){
			pageNo = 1;
		}if(pageSize==null){
			pageSize=200;
		}
		pagination = studentService.findStudents(null, new PageInfo(pageNo, pageSize));
		return SUCCESS;
	}

}
