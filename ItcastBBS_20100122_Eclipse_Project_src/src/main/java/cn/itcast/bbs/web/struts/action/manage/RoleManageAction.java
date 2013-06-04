package cn.itcast.bbs.web.struts.action.manage;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.domain.Role;
import cn.itcast.bbs.domain.SystemPrivilege;
import cn.itcast.bbs.exception.NotEmptyServiceException;
import cn.itcast.bbs.utils.web.RequestUtils;
import cn.itcast.bbs.web.struts.action.base.ManageActionBase;
import cn.itcast.bbs.web.struts.formbean.RoleActionForm;

@Controller("/manage/role")
@Permission(resource = "System", action = "Manage")
public class RoleManageAction extends ManageActionBase {

	/** 列表 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Role> roleList = roleService.findAll();
		request.setAttribute("request_list", roleList);
		return mapping.findForward("list");
	}

	/**
	 * 添加页面
	 */
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<SystemPrivilege> systemPrivilegeList = roleService.getAllSystemPrivileges();
		request.setAttribute("request_systemPrivilegeList", systemPrivilegeList);
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

		RoleActionForm actionForm = (RoleActionForm) form;
		Role role = new Role();

		Set<SystemPrivilege> systemPrivileges = roleService.getSystemPrivilegeByIdList(actionForm.getSystemPrivilegeIdList());
		role.setName(actionForm.getName());
		role.setDescription(actionForm.getDescription());
		role.setSystemPrivileges(systemPrivileges);

		roleService.save(role);
		return mapping.findForward("toList");
	}

	/**
	 * 修改页面
	 */
	public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, systemPrivilegeList
		List<SystemPrivilege> systemPrivilegeList = roleService.getAllSystemPrivileges();
		request.setAttribute("request_systemPrivilegeList", systemPrivilegeList);

		// 2, actionForm
		RoleActionForm actionForm = (RoleActionForm) form;
		Role role = roleService.getById(actionForm.getId());

		actionForm.setName(role.getName());
		actionForm.setDescription(role.getDescription());
		// systemPrivileges --> systemPrivilegeIdList
		String[] systemPrivilegeIdList = new String[role.getSystemPrivileges().size()];
		int index = 0;
		for (SystemPrivilege sp : role.getSystemPrivileges()) {
			systemPrivilegeIdList[index++] = sp.getId();
		}
		actionForm.setSystemPrivilegeIdList(systemPrivilegeIdList);

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

		RoleActionForm actionForm = (RoleActionForm) form;
		Role role = roleService.getById(actionForm.getId());

		Set<SystemPrivilege> systemPrivileges = roleService.getSystemPrivilegeByIdList(actionForm.getSystemPrivilegeIdList());
		role.setName(actionForm.getName());
		role.setDescription(actionForm.getName());
		role.setSystemPrivileges(systemPrivileges);

		roleService.update(role);
		return mapping.findForward("toList");
	}

	/**
	 * 删除
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		try {
			roleService.delete(id);
		} catch (NotEmptyServiceException e) { // 如有异常，代表分类非空（含有版面），不可被删除
			addErrorMessage(request, "delete", e.getMessage(), false);
			ActionForward af = mapping.findForward("toList");
			return new ActionForward(af.getPath(), false); // 要转发
		}
		return mapping.findForward("toList");
	}

	/** 设置是否做为新注册用户的默认角色 */
	public ActionForward setDefault(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean defaultForNewUser = RequestUtils.getBoolParam(request, "default");
		Role role = roleService.getById(id);

		role.setDefaultForNewUser(defaultForNewUser);
		roleService.update(role);
		return mapping.findForward("toList");
	}
}
