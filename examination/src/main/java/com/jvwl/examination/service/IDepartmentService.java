package com.jvwl.examination.service;

import com.jvwl.examination.dto.DepartmentDTO;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IDepartmentService<T extends BaseBean> extends IBaseService<T>{
	
	public T findByDepartId(String id);
	
	public Pagination<T> findDepartments(DepartmentDTO dep,PageInfo pageInfo);
	
}
