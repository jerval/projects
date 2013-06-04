package cn.itcast.bbs.web.struts.action.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.annotation.Permission;
import cn.itcast.bbs.web.struts.action.base.ActionBase;

@Controller("/manage/portal")
@Permission(resource = "System", action = "Manage")
public class PortalManageAction extends ActionBase {

	/** 网站管理主页 */
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("index");
	}

	
	/** 网站管理主页 */
	public ActionForward forward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String jspFileName = request.getParameter("jsp");
		return new ActionForward("/WEB-INF/pages/portal_manage/" + jspFileName + ".jsp");
	}
}
