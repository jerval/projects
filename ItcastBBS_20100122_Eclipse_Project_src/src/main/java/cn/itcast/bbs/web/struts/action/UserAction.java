package cn.itcast.bbs.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.utils.web.MemberAuthenticationUtils;
import cn.itcast.bbs.utils.web.MemberAutoLoginUtils;
import cn.itcast.bbs.utils.web.ReturnPathUtils;
import cn.itcast.bbs.web.WebConstants;
import cn.itcast.bbs.web.struts.action.base.ActionBase;
import cn.itcast.bbs.web.struts.formbean.UserActionForm;

/**
 * @author 传智播客.汤阳光 Jul 7, 2008
 */
@Controller("/user")
public class UserAction extends ActionBase {

	/** 注册页面 */
	public ActionForward regUserUI(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String returnPath = ReturnPathUtils.getReturnPathDefaultUseRefererHeaderValue(request);
		request.setAttribute("request_returnPath", returnPath);
		return mapping.findForward("regUserUI");
	}

	/** 检测loginName是否已被使用(ajax) */
	public ActionForward checkLoginName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String loginName = request.getParameter("loginName");
		Boolean result = userService.checkLoginName(loginName);

		// 把结果（true/false）写给浏览器
		response.setContentType("text/plain");
		response.getWriter().write(result.toString());
		return null;
	}

	/** 检测nickname是否已被使用(ajax) */
	public ActionForward checkNickname(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String loginName = request.getParameter("nickname");
		Boolean result = userService.checkNickname(loginName);

		// 把结果（true/false）写给浏览器
		response.setContentType("text/plain");
		response.getWriter().write(result.toString());
		return null;
	}

	/** 注册 */
	public ActionForward regUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (validateFailed(form, "forRegister", mapping, request)) { // 验证表单
			return mapping.findForward("regUserUI");
		}
		UserActionForm actionForm = (UserActionForm) form;

		ActionErrors errors = new ActionErrors();
		// 检测登录名是否可用
		if (!userService.checkLoginName(actionForm.getLoginName())) {
			errors.add("loginName", new ActionMessage("登录名【" + actionForm.getLoginName() + "】已被使用，请更换", false));
		}
		// 检测昵称是否可用
		if (!userService.checkNickname(actionForm.getNickname())) {
			errors.add("nickname", new ActionMessage("昵称【" + actionForm.getNickname() + "】已被使用，请更换", false));
		}
		// 
		if (errors.size() > 0) {
			addErrors(request, errors);
			return mapping.findForward("regUserUI");
		}

		// 1，添加用户
		User user = new User();
		BeanUtils.copyProperties(user, actionForm);
		if (actionForm.getAvatarResource() != null && actionForm.getAvatarResource().getFileSize() > 0) {
			// user.setAvatar(UserActionHelper.handleAvatar(actionForm.getAvatarResource())); // 头像
			// 不压缩头像
			user.setAvatar(actionForm.getAvatarResource().getFileData());
		}
		userService.save(user); // 保存用户信息

		// 2，登录用户
		MemberAuthenticationUtils.login(request, user);

		// 3，返回到注册前访问的页面
		if (ReturnPathUtils.rediectPreviousPage(request, response)) {
			return null;
		} else {
			return mapping.findForward("index");
		}
	}

	/**
	 * 修改密码页面
	 */
	public ActionForward changePasswordUI(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 只有登录后才可以使用
		if (!MemberAuthenticationUtils.isLoggedOn(request)) {
			return mapping.findForward("index");
		}
		return mapping.findForward("changePasswordUI");
	}

	/**
	 * 修改密码
	 */
	public ActionForward changePassword(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1, 只有登录后才可以使用
		if (!MemberAuthenticationUtils.isLoggedOn(request)) {
			return mapping.findForward("index");
		}

		// 2, 验证表单
		if (validateFailed(form, "forChangePassword", mapping, request)) {
			return mapping.findForward("changePasswordUI");
		}

		// 3, 要是本人登录后才可以修改，所以修改Session中的用户
		UserActionForm actionForm = (UserActionForm) form;
		User userInSession = MemberAuthenticationUtils.getLoggedOnUser(request);

		User user = userService.changePassword(userInSession.getId(), actionForm.getPassword());
		MemberAuthenticationUtils.login(request, user);// 更换Session中的旧的状态的User
		return mapping.findForward("index");
	}

	/**
	 * 登陆表单
	 */
	public ActionForward loginUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String returnPath = ReturnPathUtils.getReturnPathDefaultUseRefererHeaderValue(request);
		request.setAttribute("request_returnPath", returnPath);
		return mapping.findForward("loginUI");
	}

	/**
	 * 登陆
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String returnPath = request.getParameter(WebConstants.PARAMETER_RETURN_PATH);
		request.setAttribute("request_returnPath", returnPath);
		
		if (validateFailed(form, "forLogin", mapping, request)) { // 验证表单
			return mapping.findForward("loginUI");
		}

		UserActionForm actionForm = (UserActionForm) form;
		User user = userService.findByLoginNameAndPassword(actionForm.getLoginName(), actionForm.getPassword());

		// 登陆失败1：用户名或密码不正确
		if (user == null) {
			addErrorMessage(request, "loginName", "用户名或密码不正确", false);
			return mapping.findForward("loginUI");
		}

		// 登陆失败2：用户被锁定
		if (user.isLocked()) {
			addErrorMessage(request, "loginName", "用户已被锁定，不能登陆。请与管理理员联系", false);
			return mapping.findForward("loginUI");
		}

		// 1，用户名密码验证通过，登陆用户
		MemberAuthenticationUtils.login(request, user);

		// 2，如果选择了自动登录，就启动自动登录
		if (actionForm.isAutoLogin()) {
			// 1, 发送Cookie并更新User中的autoLoginAuthKey
			// int autoLoginDays = actionForm.getAutoLoginDays();
			// FIXME 默认自动登录时间为30天
			int autoLoginDays = 30;
			MemberAutoLoginUtils.addAutoLoginCookieAndSetUserAutoLoginAuthKey(user, autoLoginDays, response);
			// 2, 保存到服务器端(数据库中)
			userService.update(user);
		}

		// 3，返回到登录前访问的页面
		if (ReturnPathUtils.rediectPreviousPage(request, response)) {
			return null;
		} else {
			return mapping.findForward("index");
		}
	}

	/**
	 * 注销
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1，删除自动登录的Cookie
		User user = MemberAuthenticationUtils.getLoggedOnUser(request);
		MemberAutoLoginUtils.delAutoLoginCookieAndClearUserAutoLoginAuthKey(response, user);
		// 2，注销
		MemberAuthenticationUtils.logout(request);

		// 3，返回到注册前访问的页面
		String returnPath = ReturnPathUtils.getReturnPathDefaultUseRefererHeaderValue(request);
		if (ReturnPathUtils.rediectPreviousPage(request, response, returnPath)) {
			return null;
		} else {
			return mapping.findForward("index");
		}
	}

	/**
	 * 查看用户头像
	 */
	public ActionForward showAvatar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserActionForm actionForm = (UserActionForm) form;
		User user = userService.getById(actionForm.getId());

		if (user.getAvatar() != null) { // 有的用户没有头像
			response.setContentType("image/jpeg");
			response.getOutputStream().write(user.getAvatar());
		}
		return null;
	}

}
