package cn.itcast.bbs.web.struts.action.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;

@Controller("/manage/reply")
public class ReplyManageAction extends ManageActionBase {

	/**
	 * 回复删除
	 */
	@Permission(resource = "Reply", action = "Delete")
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		replyService.delete(id);

		String topicId = request.getParameter("topicId");
		ActionForward af = mapping.findForward("toTopicShow");
		String params = "&id=" + topicId + "&pageNum=" + getPageNum(request) + "&pageSize=" + getPageSize(request);
		return new ActionForward(af.getPath() + params, af.getRedirect());
	}

}
