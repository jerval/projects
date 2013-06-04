package cn.itcast.bbs.web.struts.action.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.BlogLink;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.BlogLinkActionForm;

@Controller("/manage/blogLink")
@Permission(resource = "System", action = "Manage")
public class BlogLinkManageAction extends ManageActionBase {

	/** 列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<BlogLink> blogLinkList = blogLinkService.findAll();
		request.setAttribute("request_list", blogLinkList);
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

		BlogLinkActionForm actionForm = (BlogLinkActionForm) form;
		BlogLink blogLink = new BlogLink();
		// FIXME copy后的id为空字符串（传递过来的参数），这样会在psist时出错：detached entity passed to persist
		BeanUtils.copyProperties(blogLink, actionForm); // copy properties
		// 所以要再设置id为null
		blogLink.setId(null); 

		blogLinkService.save(blogLink);
		return mapping.findForward("toList");
	}

	/**
	 * 修改页面
	 */
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// actionForm
		BlogLinkActionForm actionForm = (BlogLinkActionForm) form;
		BlogLink blogLink = blogLinkService.getById(actionForm.getId());

		BeanUtils.copyProperties(actionForm, blogLink); // copy properties
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

		BlogLinkActionForm actionForm = (BlogLinkActionForm) form;
		BlogLink blogLink = blogLinkService.getById(actionForm.getId());
		BeanUtils.copyProperties(blogLink, actionForm); // copy properties

		blogLinkService.update(blogLink);
		return mapping.findForward("toList");
	}

	/**
	 * 删除
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		blogLinkService.delete(id);
		return mapping.findForward("toList");
	}

}
