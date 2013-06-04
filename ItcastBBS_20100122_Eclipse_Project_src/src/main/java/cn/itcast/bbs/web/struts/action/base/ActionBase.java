package cn.itcast.bbs.web.struts.action.base;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import cn.itcast.bbs.dd.DDConstants;
import cn.itcast.bbs.dd.DataDict;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.exception.ActionException;
import cn.itcast.bbs.exception.PermissionDeniedException;
import cn.itcast.bbs.service.BlogLinkService;
import cn.itcast.bbs.service.CategoryService;
import cn.itcast.bbs.service.ForumService;
import cn.itcast.bbs.service.ReplyService;
import cn.itcast.bbs.service.RoleService;
import cn.itcast.bbs.service.SystemLogService;
import cn.itcast.bbs.service.TopicSearchService;
import cn.itcast.bbs.service.TopicService;
import cn.itcast.bbs.service.UserService;
import cn.itcast.bbs.utils.web.MemberAuthenticationUtils;
import cn.itcast.bbs.utils.web.RequestUtils;
import cn.itcast.bbs.utils.web.ReturnPathUtils;
import cn.itcast.bbs.web.WebConstants;

/**
 * FIXME 防止表单重复提交(后退后再次提交)
 * 
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
public class ActionBase extends DispatchAction {
	protected static Log log = LogFactory.getLog(ActionBase.class);

	@Resource
	protected UserService userService;
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected BlogLinkService blogLinkService;
	@Resource
	protected SystemLogService systemLogService;
	@Resource
	protected TopicSearchService topicSearchService;

	//
	// @Resource
	// protected AttachmentService attachmentService;
	// @Resource
	// protected VoteService voteService;
	// @Resource
	// protected ArticleSearchService articleSearchService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			return super.execute(mapping, form, request, response);
		}
		// 如果没有权限执行某个方法
		// FIXME 这里不起作用了，因为PrivilegeInterceptorDelegatingRequestProcessor是在Action外层，无权限异常在外层抛出
		catch (PermissionDeniedException e) {
			// 1. 如果未登陆, 转到登陆界面
			if (!MemberAuthenticationUtils.isLoggedOn(request)) {
				// 可以在登陆后再转到登陆前的页面, 这个页面地址可以放到 request 作用域中;
				String unencodedReturnPath = (String) request.getAttribute(WebConstants.REQUEST_UNENCODED_RETURN_PATH);
				// 转到登录页面
				ReturnPathUtils.toLoginWithReturnPathDefaultIsCurrentRequestURI(request, response, unencodedReturnPath);
				return null;
			}

			// 2. 如果已登陆, 抛出权限不足异常
			throw e;
		}
	}

	/**
	 * 获取pageNum参数，默认值为1
	 * 
	 * @param request
	 * @return
	 */
	protected int getPageNum(HttpServletRequest request) {
		int pageNum = RequestUtils.getIntegerParam(request, "pageNum", 1);
		if (pageNum == 0) {
			pageNum = 1;
		}
		return pageNum;
	}

	/**
	 * 获取pageNum参数，默认值为由系统设定（DataDict）
	 * 
	 * @param request
	 * @return
	 */
	protected int getPageSize(HttpServletRequest request) {
		int pageSize = RequestUtils.getIntegerParam(request, "pageSize", DataDict.getInt(DDConstants.DEFAULT_PAGE_SIZE));
		if (pageSize == 0) {
			pageSize = DataDict.getInt(DDConstants.DEFAULT_PAGE_SIZE);
		}
		return pageSize;
	}

	/**
	 * 验证FormBean, 通过调用 {@link ActionForm#validate(ActionMapping, HttpServletRequest)}方法
	 * 
	 * @param form
	 * @param mapping
	 * @param request
	 * @return 表单是否验证失败
	 */
	protected boolean validateFailed(ActionForm form, ActionMapping mapping, HttpServletRequest request) {
		ActionMessages errors = form.validate(mapping, request);
		if (errors != null && errors.size() > 0) {
			this.saveErrors(request, errors);
			return true;
		}
		return false;
	}

	/**
	 * 验证formbean, 通过指定的验证方法, 要求这个验证方法的签名要和<br>
	 * {@link ActionForm#validate(ActionMapping, HttpServletRequest)}方法的签名一致
	 * 
	 * @param form
	 * @param validateMethodName 验证方法
	 * @param mapping
	 * @param request
	 * @return
	 */
	protected boolean validateFailed(ActionForm form, String validateMethodName, ActionMapping mapping, HttpServletRequest request) {
		try {
			Method method = form.getClass().getMethod(validateMethodName, ActionMapping.class, HttpServletRequest.class);
			ActionMessages errors = (ActionMessages) method.invoke(form, mapping, request);
			if (errors.size() > 0) {
				this.saveErrors(request, errors);
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new ActionException(e);
		}
	}

	/**
	 * 添加一个错误消息, 并把这个错误信息的集合放到request作用域
	 * 
	 * @param request
	 * @param property
	 * @param key
	 * @param resourse
	 * @return
	 */
	protected ActionMessages addErrorMessage(HttpServletRequest request, String property, String key, boolean resourse) {
		ActionMessages errors = this.getErrors(request); // 如果没有，会返回一个新的ActionMessages对象
		errors.add(property, new ActionMessage(key, resourse));
		addErrors(request, errors);
		return errors;
	}

	/**
	 * 用request中的pageNum与pageSize参数构建一个CriteriaBean对象。<br>
	 * pageNum 的默认值为1 <br>
	 * pageSize 的默认值为数据字典中保存的默认页面大小<br>
	 * 
	 * @param request
	 * @return
	 */
	public CriteriaBean createCriteriaBeanWithPageNumAndPageSize(HttpServletRequest request) {
		return new CriteriaBean(getPageNum(request), getPageSize(request));
	}
}
