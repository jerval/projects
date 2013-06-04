package com.jvwl.forum.service.base;

import com.jvwl.forum.dao.base.BaseDaoImpl;
import com.jvwl.forum.model.base.BaseBean;

public abstract class BaseServiceImpl<T extends BaseBean> extends
		BaseDaoImpl<T> implements BaseService<T> {

}
