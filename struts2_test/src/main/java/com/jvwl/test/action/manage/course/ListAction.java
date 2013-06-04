package com.jvwl.test.action.manage.course;

import com.jvwl.test.action.BaseAction;
import com.jvwl.test.dto.PageInfo;
import com.jvwl.test.dto.Pagination;
import com.jvwl.test.model.Course;
import com.jvwl.test.service.CourseService;

@SuppressWarnings("serial")
public class ListAction extends BaseAction {

	private Pagination<Course> pagination;
	private CourseService courseService = new CourseService();
	private Integer pageNo;
	private Integer pageSize;

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Pagination<Course> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Course> pagination) {
		this.pagination = pagination;
	}

	@Override
	public String execute() throws Exception {
		if(pageNo==null){
			pageNo = 1;
		}if(pageSize==null){
			pageSize=200;
		}
		pagination = courseService.findCourses(null, new PageInfo(pageNo, pageSize));
		return SUCCESS;
	}

}
