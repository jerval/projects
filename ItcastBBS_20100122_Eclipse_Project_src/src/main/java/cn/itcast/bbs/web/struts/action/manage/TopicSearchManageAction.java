package cn.itcast.bbs.web.struts.action.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;

/**
 * @author 传智播客.汤阳光 Jul 19, 2008
 */
@Controller("/manage/topicSearch")
@Permission(resource = "System", action = "Manage")
public class TopicSearchManageAction extends ManageActionBase {

	/** 信息列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int topicCount = topicService.getCount();
		int searchableTopicCount = topicSearchService.getCount();

		request.setAttribute("topicCount", topicCount);
		request.setAttribute("searchableTopicCount", searchableTopicCount);
		return mapping.findForward("list");
	}

	/** 重新创建所有主题的索引 */
	public ActionForward reCreateAll(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		topicSearchService.reCreateAll();
		return mapping.findForward("toList");
	}

}
