package cn.itcast.bbs.service.base;

import cn.itcast.bbs.dao.base.DaoBase;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.PageView;

public interface ServiceBase<T> extends DaoBase<T> {

	/**
	 * 根据条件获取（指定页的）分页信息
	 * 
	 * @param criteriaBean
	 * @return
	 */
	PageView getPageViewByCriteriaBean(CriteriaBean criteriaBean);
}
