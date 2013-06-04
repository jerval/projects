package com.jvwl.train.service.base;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dao.base.BaseDao;
import com.jvwl.train.model.base.BaseBean;

/**
 * 业务基类接口
 * 
 * @author jerval
 */
public interface BaseService<T extends BaseBean, E> extends BaseDao<T> {
	/**
	 * 能过传入的DTO来查找实体
	 * @param dto：要传入的DTO对象
	 * @param pageInfo：页面信息，包含pageSize,pageNo
	 * @return:封装了页面信息和查找到的实体的一个封装类
	 */
	public Pagination<T> findObjects(E dto, PageInfo pageInfo);

	/**
	 * 能过传入的DTO来查找实体
	 * @param dto：要传入的DTO对象
	 * @param pageInfo：页面信息，包含pageSize,pageNo
	 * @param deleted：查找删除的或未删除的
	 * @return：封装了页面信息和查找到的实体的一个封装类
	 */
	public Pagination<T> findObjects(E dto, PageInfo pageInfo, Boolean deleted);

	/**
	 * 通过传入的DTO生成相应的QLWhere语句
	 * @param dto：要传入的DTO对象
	 * @return：生成的QL语句
	 */
	public String getSqlWhere(E dto);
}
