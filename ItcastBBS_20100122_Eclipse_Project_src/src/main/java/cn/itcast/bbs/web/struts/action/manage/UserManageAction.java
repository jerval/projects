package cn.itcast.bbs.web.struts.action.manage;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.utils.web.RequestUtils;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.UserActionForm;

/**
 * @author 传智播客.汤阳光 Jul 7, 2008
 */
@Controller("/manage/user")
@Permission(resource = "System", action = "Manage")
public class UserManageAction extends ManageActionBase {

	/** 用户列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, roleList
		List<Role> roleList = roleService.findAll();
		request.setAttribute("request_roleList", roleList);

		// 2, pageView
		UserActionForm actionForm = (UserActionForm) form;
		CriteriaBean criteriaBean = createCriteriaBeanWithPageNumAndPageSize(request);

		// 过滤条件
		if (StringUtils.isNotBlank(actionForm.getLoginName())) {
			criteriaBean.addRestriction(Restrictions.like("loginName", "%" + actionForm.getLoginName() + "%"));
		}
		if (StringUtils.isNotBlank(actionForm.getNickname())) {
			criteriaBean.addRestriction(Restrictions.like("nickname", "%" + actionForm.getNickname() + "%"));
		}
		if (StringUtils.isNotBlank(actionForm.getLocked())) {
			// 在ActionForm中使用String。因为使用Boolean型时，即使用值为null，也会默认选中false.
			boolean locked = RequestUtils.getBoolParam(request, "locked");
			criteriaBean.addRestriction(Restrictions.eq("locked", locked));
		}
		if (StringUtils.isNotBlank(actionForm.getRoleId())) {
			// FIXME 怎么查询？以下需要修改Criteria配合
			DetachedCriteria dc = criteriaBean.buildDetachedCriteria(User.class.getName());
			dc.createCriteria("roles").add(Restrictions.eq("id", actionForm.getRoleId()));
		}

		PageView pageView = userService.getPageViewByCriteriaBean(criteriaBean);
		request.setAttribute("request_pageView", pageView);
		return mapping.findForward("list");
	}

	/**
	 * 修改用户所属的角色页面
	 */
	public ActionForward selectRolesUI(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserActionForm actionForm = (UserActionForm) form;

		// 1, 准备 user
		User user = userService.getById(actionForm.getId());
		request.setAttribute("request_user", user);

		// 2, 准备 roleList
		List<Role> roleList = roleService.findAll();
		request.setAttribute("request_roleList", roleList);

		// 3, 准备 actionForm, 用于在页面中显示
		int index = 0;
		String[] roleIdList = new String[user.getRoles().size()];
		for (Role role : user.getRoles()) {
			roleIdList[index++] = role.getId();
		}
		actionForm.setRoleIdList(roleIdList);

		return mapping.findForward("selectRolesUI");
	}

	/** 修改用户所属的角色 */
	public ActionForward selectRoles(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserActionForm actionForm = (UserActionForm) form;
		List<Role> roleList = roleService.getByIdList(actionForm.getRoleIdList());

		User user = userService.getById(actionForm.getId());
		user.setRoles(new HashSet<Role>(roleList));
		userService.update(user);

		ActionForward af = mapping.findForward("toList");
		String params = "&pageNum=" + getPageNum(request) + "&pageSize=" + getPageSize(request);
		return new ActionForward(af.getPath() + params, af.getRedirect());
	}

	/** 锁定用户 */
	public ActionForward lock(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		userService.lock(id);

		ActionForward af = mapping.findForward("toList");
		String params = "&pageNum=" + getPageNum(request) + "&pageSize=" + getPageSize(request);
		return new ActionForward(af.getPath() + params, af.getRedirect());
	}

	/** 解锁用户 */
	public ActionForward unlock(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		userService.unlock(id);

		ActionForward af = mapping.findForward("toList");
		String params = "&pageNum=" + getPageNum(request) + "&pageSize=" + getPageSize(request);
		return new ActionForward(af.getPath() + params, af.getRedirect());
	}
}
