package cn.itcast.bbs.web.struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.Article;
import cn.itcast.bbs.domain.Reply;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.utils.ArticleUtils;
import cn.itcast.bbs.utils.web.MemberAuthenticationUtils;
import cn.itcast.bbs.web.struts.action.base.ActionBase;
import cn.itcast.bbs.web.struts.formbean.ReplyActionForm;

@Controller("/reply")
public class ReplyAction extends ActionBase {

	/**
	 * 回复/引用 页面
	 */
	@Permission(resource = "Reply", action = "Create")
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, topic
		ReplyActionForm actionForm = (ReplyActionForm) form;
		Topic topic = topicService.getById(actionForm.getTopicId());
		request.setAttribute("request_topic", topic);

		// 2, actionForm
		actionForm.setTitle("回复：" + topic.getTitle());

		// 3, quoted article info
		String quotedArticleId = request.getParameter("quotedArticleId"); // 有此参数说明是引用
		if (StringUtils.isNotBlank(quotedArticleId)) {
			Article quotedArticle = replyService.getById(Article.class, quotedArticleId);
			String content = "<div class='quote'><b>" //
					+ quotedArticle.getAuthor().getNickname() //
					+ " 说:</b> " + quotedArticle.getContent() //
					+ "</div><br>";
			actionForm.setContent(content);
		}

		return mapping.findForward("saveUI");
	}

	/**
	 * 回复添加(只是内容)
	 */
	@Permission(resource = "Reply", action = "Create")
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // 验证表单
			return addUI(mapping, form, request, response);
		}

		// // 验证发帖时间间隔
		// if (!ArticleActionHelper.checkPostDelay(request)) {
		// addError(request, "postDelay", "距上次发帖间隔时间太短, 您不能发表新文章. 请稍候再试.", false);
		// return addUI(mapping, form, request, response);
		// }

		ReplyActionForm actionForm = (ReplyActionForm) form;
		Topic topic = topicService.getById(actionForm.getTopicId());
		User user = MemberAuthenticationUtils.getLoggedOnUser(request);
		String content = ArticleUtils.makeHtmlElementsSafe(actionForm.getContent());
		
		Reply reply = new Reply();
		reply.setAuthor(user);
		reply.setTopic(topic);
		reply.setContent(content);
		reply.setPostTime(new Date());
		reply.setIpAddr(request.getRemoteAddr());
		replyService.save(reply);

		// 应显示本回复所在的页(最后一页)
		ActionForward af = mapping.findForward("toTopicShow");
		return new ActionForward(af.getPath() + "&id=" + topic.getId() + "&pageNum=" + PageView.LAST_PAGE, af.getRedirect());
	}

	/**
	 * 修改回复页面
	 */
	@Permission(resource = "Reply", action = "Update")
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, topic
		ReplyActionForm actionForm = (ReplyActionForm) form;
		Reply reply = replyService.getById(actionForm.getId());
		request.setAttribute("request_topic", reply.getTopic());

		// 2, actionForm
		actionForm.setTitle(reply.getTitle());
		actionForm.setContent(reply.getContent());
		actionForm.setTopicId(reply.getTopic().getId());

		return mapping.findForward("saveUI");
	}

	/**
	 * 修改回复（只是内容）
	 */
	@Permission(resource = "Reply", action = "Update")
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // 验证表单
			return editUI(mapping, form, request, response);
		}

		ReplyActionForm actionForm = (ReplyActionForm) form;
		Reply reply = replyService.getById(actionForm.getId());
		reply.setTitle(actionForm.getTitle());
		reply.setContent(actionForm.getContent());

		replyService.update(reply);

		// 应显示本回复所在的页
		Topic topic = reply.getTopic();
		ActionForward af = mapping.findForward("toTopicShow");
		String params = "&id=" + topic.getId() + "&pageNum=" + getPageNum(request) + "&pageSize=" + getPageSize(request);
		return new ActionForward(af.getPath() + params, af.getRedirect());
	}

}
