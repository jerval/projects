package com.jvwl.examination.service;

import com.jvwl.examination.dto.EmployeeDTO;
import com.jvwl.examination.dto.LoginInfo;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.BaseBean;

public interface IEmployeeService<T extends BaseBean> extends IBaseService<T> {

	public T findByEmployeeId(String id);

	public Pagination<T> findEmployees(EmployeeDTO emp, PageInfo pageInfo);

	public T login(LoginInfo loginInfo);
}
