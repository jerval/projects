package cn.itcast.bbs.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.web.struts.action.base.ActionBase;
import cn.itcast.bbs.web.struts.formbean.TopicSearchActionForm;

/**
 * @author 传智播客.汤阳光 Jul 7, 2008
 */
@Controller("/topicSearch")
public class TopicSearchAction extends ActionBase {

	/**
	 * 搜索页面
	 */
	public ActionForward searchTopicUI(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("resultList");
	}

	/**
	 * 搜索
	 */
	public ActionForward searchTopic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageView pageView = null;
		String queryString = request.getParameter("queryString");

		if (queryString != null) {
			// 搜索的表单是可以使用get方式传递的数据
			if ("GET".equals(request.getMethod())) {
				queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			}

			if (StringUtils.isNotBlank(queryString)) {
				TopicSearchActionForm actionform = (TopicSearchActionForm) form;
				actionform.setQueryString(queryString);// 替换掉乱码（如果是GET方式）
				pageView = topicSearchService.getPageView(queryString, actionform.getPageNum(), actionform.getPageSize());
			}
		}

		if (pageView == null) { //
			pageView = PageView.EMPTY_PAGE_VIEW;
		}

		request.setAttribute("request_pageView", pageView);
		return mapping.findForward("resultList");
	}

}
