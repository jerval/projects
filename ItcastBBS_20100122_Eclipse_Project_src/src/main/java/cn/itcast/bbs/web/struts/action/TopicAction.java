package cn.itcast.bbs.web.struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.utils.ArticleUtils;
import cn.itcast.bbs.utils.web.MemberAuthenticationUtils;
import cn.itcast.bbs.web.struts.action.base.ActionBase;
import cn.itcast.bbs.web.struts.formbean.TopicActionForm;

@Controller("/topic")
public class TopicAction extends ActionBase {

	// /**
	// * 普通主题列表
	// */
	// public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// // 1, forum
	// String forumId = request.getParameter("forumId");
	// Forum forum = forumService.getById(forumId);
	// request.setAttribute("request_forum", forum);
	//
	// // 2, pageView --> setAttr
	// CriteriaBean criteriaBean = createCriteriaBeanWithPageNumAndPageSize(request)//
	// .addRestriction(Restrictions.eq("forum", forum))//
	// .addRestriction(Restrictions.eq("deleted", false))//
	// .addOrder(Order.desc("lastArticlePostTime")); // 按最后更新时间降序排列
	// PageView pageView = topicService.getPageViewByCriteriaBean(criteriaBean);
	// request.setAttribute("request_pageView", pageView);
	//
	// return mapping.findForward("list");
	// }

	/**
	 * 主题显示
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, topic
		String id = request.getParameter("id");
		Topic topic = topicService.getById(id);
		request.setAttribute("request_topic", topic);

		if (topic == null) {
			return mapping.findForward("show_nonexistent");
		}

		// 2, reply's pageView
		CriteriaBean criteriaBean = createCriteriaBeanWithPageNumAndPageSize(request)//
				.addRestriction(Restrictions.eq("topic", topic))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.asc("postTime"));
		PageView pageView = replyService.getPageViewByCriteriaBean(criteriaBean);
		request.setAttribute("request_pageView", pageView);

		// 3, increment view count
		topicService.increment(id, "viewCount");
		return mapping.findForward("show");
	}

	/**
	 * 发表页面
	 */
	@Permission(resource = "Topic", action = "Create")
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 这里不要使用request.getParameter来获得forumId,
		// 因为 form 是 multipart/form-data 编码类型,
		// FIXME ?? 如果是验证失败后转发过来的,使用request.getParameter就得不到参数了
		// 因为失败后转发时会把包装的StrutsRequest去掉，再拿到的就是原始的Reqest，要使用上传组件才能获得？
		// 我记得好像是这样，还要做实验。如果是这样，就可以使用ActionForm，他里面还存有封装的参数值。

		// 1, forum
		TopicActionForm actionForm = (TopicActionForm) form;
		Forum forum = forumService.getById(actionForm.getForumId());
		request.setAttribute("request_forum", forum);

		return mapping.findForward("saveUI");
	}

	/**
	 * 主题发表(只是标题、内容、类型)
	 */
	@Permission(resource = "Topic", action = "Create")
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // 验证表单
			return addUI(mapping, form, request, response);
		}

		// FIXME 验证发帖时间间隔
		// if (!ArticleActionHelper.checkPostDelay(request)) {
		// addError(request, "postDelay", "距上次发帖间隔时间太短, 您不能发表新文章. 请稍候再试.", false);
		// return addUI(mapping, form, request, response);
		// }

		TopicActionForm actionForm = (TopicActionForm) form;
		Forum forum = forumService.getById(actionForm.getForumId());
		User author = MemberAuthenticationUtils.getLoggedOnUser(request);
		// 在页面中使用FCKeditor，可以转换标签。但可以绕过，即自已造一个表单，提交地址为这里，就可以随便写了。
		// 所以还要再过滤标签。
		String content = ArticleUtils.makeHtmlElementsSafe(actionForm.getContent());

		Topic topic = new Topic();
		topic.setAuthor(author);
		topic.setForum(forum);
		topic.setPostTime(new Date());
		topic.setIpAddr(request.getRemoteAddr());

		topic.setTitle(actionForm.getTitle());
		topic.setContent(content);
		topic.setType(actionForm.getType());
		topic.setSummary(actionForm.getSummary());

		topicService.save(topic); // Add new
		// FIXME refreshLastPostTime
		// ArticleActionHelper.refreshLastPostTime(request); // refresh last post time

		ActionForward af = mapping.findForward("toShow");
		return new ActionForward(af.getPath() + "&pageNum=1&id=" + topic.getId(), af.getRedirect());
	}

	/**
	 * 修改页面
	 */
	@Permission(resource = "Topic", action = "Update")
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, forum
		TopicActionForm actionForm = (TopicActionForm) form;
		Topic topic = topicService.getById(actionForm.getId());
		request.setAttribute("request_forum", topic.getForum());

		// 2, actionForm
		actionForm.setTitle(topic.getTitle());
		actionForm.setContent(topic.getContent());
		actionForm.setType(topic.getType());
		actionForm.setSummary(topic.getSummary());
		actionForm.setForumId(topic.getForum().getId());

		return mapping.findForward("saveUI");
	}

	/**
	 * 主题修改(只是标题、内容、类型)
	 */
	@Permission(resource = "Topic", action = "Update")
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // 验证表单
			return editUI(mapping, form, request, response);
		}

		TopicActionForm actionForm = (TopicActionForm) form;
		Topic topic = topicService.getById(actionForm.getId());

		topic.setTitle(actionForm.getTitle());
		topic.setContent(actionForm.getContent());
		topic.setType(actionForm.getType());
		topic.setSummary(actionForm.getSummary());

		topicService.update(topic); // Update

		ActionForward af = mapping.findForward("toShow");
		return new ActionForward(af.getPath() + "&pageNum=1&id=" + topic.getId(), af.getRedirect());
	}

}
