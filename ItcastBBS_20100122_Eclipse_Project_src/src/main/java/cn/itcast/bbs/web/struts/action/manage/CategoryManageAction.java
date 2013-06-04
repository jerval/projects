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
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.utils.web.RequestUtils;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.CategoryActionForm;

/**
 * @author 传智播客.汤阳光 Jun 6, 2008
 */
@Controller("/manage/category")
@Permission(resource = "System", action = "Manage")
public class CategoryManageAction extends ManageActionBase {

	/**
	 * 显示所有分类与版面的列表
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);
		return mapping.findForward("list");
	}

	/**
	 * 添加页面
	 */
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("saveUI");
	}

	/**
	 * 添加
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // validate form bean
			return mapping.findForward("saveUI");
		}

		CategoryActionForm actionForm = (CategoryActionForm) form;
		Category category = new Category();
		category.setName(actionForm.getName());

		categoryService.save(category);
		return mapping.findForward("toList");
	}

	/**
	 * 修改页面
	 */
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm actionForm = (CategoryActionForm) form;
		Category category = categoryService.getById(actionForm.getId());

		actionForm.setName(category.getName());
		return mapping.findForward("saveUI");
	}

	/**
	 * 修改
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, mapping, request)) { // validate form bean
			return mapping.findForward("saveUI");
		}

		CategoryActionForm actionForm = (CategoryActionForm) form;
		Category category = categoryService.getById(actionForm.getId());

		category.setName(actionForm.getName());
		categoryService.update(category);
		return mapping.findForward("toList");
	}

	/**
	 * 分类删除
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		try {
			categoryService.delete(id);
			return mapping.findForward("toList");
		} catch (NotEmptyServiceException e) { // 如有异常，代表分类非空（含有版面），不可被删除
			addErrorMessage(request, "delete", e.getMessage(), false);
			ActionForward af = mapping.findForward("toList");
			return new ActionForward(af.getPath(), false); // 要转发
		}
	}

	/**
	 * 上移/下移
	 */
	public ActionForward move(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryActionForm categoryForm = (CategoryActionForm) form;
		boolean isUp = RequestUtils.getBoolParam(request, "isUp");
		categoryService.move(categoryForm.getId(), isUp);
		return mapping.findForward("toList");
	}

}
