package com.jvwl.train.service.base;

import com.jvwl.train.dao.base.BaseDaoImpl;
import com.jvwl.train.model.base.BaseBean;
/**
 * 业务基类实现
 * @author jerval
 */
public abstract class BaseServiceImpl<T extends BaseBean,E> extends
		BaseDaoImpl<T> implements BaseService<T,E> {
}
