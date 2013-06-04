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
import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.utils.web.RequestUtils;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.ForumActionForm;

/**
 * @author 传智博客.汤阳光 Jun 11, 2008
 */
@Controller("/manage/forum")
@Permission(resource = "System", action = "Manage")
public class ForumManageAction extends ManageActionBase {

	/**
	 * 添加新版面页面
	 */
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);
		return mapping.findForward("saveUI");
	}

	/**
	 * 添加新版面
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // validate form bean
			return addUI(mapping, form, request, response);
		}

		ForumActionForm actionForm = (ForumActionForm) form;
		Category category = categoryService.getById(actionForm.getCategoryId());

		Forum forum = new Forum();
		forum.setName(actionForm.getName());
		forum.setDescription(actionForm.getDescription());
		forum.setCategory(category);

		forumService.save(forum);
		return mapping.findForward("toCategoryList");
	}

	/**
	 * 修改版面信息页面
	 */
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, categoryList
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);

		// 2, actionForm
		ForumActionForm actionForm = (ForumActionForm) form;
		// 第一次到修改页面时才需要准备数据,出错后转发过来的应显示上次的错误输入
		if (actionForm.getCategoryId() == null) {
			Forum forum = forumService.getById(actionForm.getId());

			actionForm.setName(forum.getName());
			actionForm.setDescription(forum.getDescription());
			actionForm.setCategoryId(forum.getCategory().getId());
		}

		return mapping.findForward("saveUI");
	}

	/**
	 * 修改版面信息
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // validate form bean
			return editUI(mapping, form, request, response);
		}

		ForumActionForm actionForm = (ForumActionForm) form;
		Forum forum = forumService.getById(actionForm.getId());
		Category category = categoryService.getById(actionForm.getCategoryId());

		forum.setName(actionForm.getName());
		forum.setDescription(actionForm.getDescription());
		forum.setCategory(category);

		forumService.update(forum);
		return mapping.findForward("toCategoryList");
	}

	/**
	 * 删除版面
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		try {
			forumService.delete(id);
			return mapping.findForward("toCategoryList");
		} catch (NotEmptyServiceException e) { // 如有异常，代表版面非空（含有主题），不可被删除
			addErrorMessage(request, "delete", e.getMessage(), false);
			ActionForward af = mapping.findForward("toCategoryList");
			return new ActionForward(af.getPath(), false); // 要转发
		}
	}

	/**
	 * 上移/下移
	 */
	public ActionForward move(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ForumActionForm forumForm = (ForumActionForm) form;
		boolean isUp = RequestUtils.getBoolParam(request, "isUp");
		forumService.move(forumForm.getId(), isUp);
		return mapping.findForward("toCategoryList");
	}

}
