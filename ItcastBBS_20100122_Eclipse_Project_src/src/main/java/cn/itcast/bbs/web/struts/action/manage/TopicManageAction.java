package cn.itcast.bbs.web.struts.action.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.TopicActionForm;

@Controller("/manage/topic")
public class TopicManageAction extends ManageActionBase {

	
	/**
	 * 更改主题的类型
	 */
	@Permission(resource = "Topic", action = "Update")
	public ActionForward changeTypeUI(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TopicActionForm actionForm = (TopicActionForm)form;
		Topic topic = topicService.getById(actionForm.getId());
		actionForm.setType(topic.getType());
		
		request.setAttribute("request_topic", topic);
		return mapping.findForward("changeTypeUI");
	}
	
	/**
	 * 更改主题的类型
	 */
	@Permission(resource = "Topic", action = "Update")
	public ActionForward changeType(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		Topic topic = topicService.getById(id);
		topic.setType(type);
		topicService.update(topic);

		ActionForward af = mapping.findForward("toTopicShow");
		return new ActionForward(af.getPath() + "&pageNum=1&id=" + topic.getId(), af.getRedirect());
	}

	/**
	 * 主题删除
	 */
	@Permission(resource = "Topic", action = "Delete")
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		topicService.delete(id);

		String forumId = request.getParameter("forumId");
		ActionForward af = mapping.findForward("toForumShowRight");
		return new ActionForward(af.getPath() + "&pageNum=1&id=" + forumId, af.getRedirect());
	}

	/**
	 * 移动主题页面
	 */
	@Permission(resource = "Topic", action = "Move")
	public ActionForward moveUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, topic
		TopicActionForm actionForm = (TopicActionForm)form;
		Topic topic = topicService.getById(actionForm.getId());
		request.setAttribute("request_topic", topic);

		// 2, categoryList
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);
		
		// 3, actionForm
		actionForm.setForumId(topic.getForum().getId());
		
		return mapping.findForward("moveUI");
	}

	/**
	 * 移动主题
	 */
	@Permission(resource = "Topic", action = "Move")
	public ActionForward move(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		String destForumId = request.getParameter("forumId");
		topicService.move(id, destForumId);

		return mapping.findForward("toForumShowRight");
	}

}
