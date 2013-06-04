package cn.itcast.bbs.service.base;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.dao.base.DaoImplBase;
import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.search.base.GenericIndexDao;

/**
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class ServiceImplBase<T> extends DaoImplBase<T> implements ServiceBase<T> {
	protected static Log log = LogFactory.getLog(ServiceImplBase.class);
	
	@Resource(name = "topicIndexDao")
	protected GenericIndexDao<SearchableTopic> topicIndexDao;

	public PageView getPageViewByCriteriaBean(CriteriaBean criteriaBean) {
		int pageNum = criteriaBean.getPageNum();
		int pageSize = criteriaBean.getPageSize();

		// 1, query record count
		int count = criteriaBean.queryRecordCount(getSession(), getEntityName());
		if(count == 0){
			return PageView.EMPTY_PAGE_VIEW;
		}
		
		// 2, 如果是要查看的页码比超过总页码数的数量，则显示最后一页
		// // 在删除一页面的最后一条数据时，就会出现这种情况
		int totalPage = (count + pageSize - 1) / pageSize;
		if (pageNum > totalPage) {
			// 设置新的页码后重新查询
			pageNum = totalPage;
			criteriaBean.setPageNum(totalPage);
			count = criteriaBean.queryRecordCount(getSession(), getEntityName());
		}
		// 3, query record list
		List<T> list = criteriaBean.queryRecordList(getSession(), getEntityName());

		return new PageView(pageNum, pageSize, count, list);
	}

}
