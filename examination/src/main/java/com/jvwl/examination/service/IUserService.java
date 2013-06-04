package com.jvwl.examination.service;

import com.jvwl.examination.dto.LoginInfo;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.dto.UserDTO;
import com.jvwl.examination.model.BaseBean;

public interface IUserService<T extends BaseBean> extends IBaseService<T> {

	public T findByUsername(String username);

	public Pagination<T> findUsers(UserDTO uDto, PageInfo pageInfo);

	public T login(LoginInfo loginInfo);
}
