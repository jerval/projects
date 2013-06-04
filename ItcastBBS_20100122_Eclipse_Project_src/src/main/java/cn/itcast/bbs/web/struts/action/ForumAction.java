package cn.itcast.bbs.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.domain.query.PageView;
import cn.itcast.bbs.utils.web.ReturnPathUtils;
import cn.itcast.bbs.web.struts.action.base.ActionBase;

/**
 * @author 传智播客.汤阳光 Jun 6, 2008
 */
@Controller("/forum")
public class ForumAction extends ActionBase {

	// /**
	// * 列表显示分类和版面
	// */
	// public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// List<Category> categoryList = categoryService.findAll();
	// request.setAttribute("request_categoryList", categoryList);
	// return mapping.findForward("list");
	// }

	/**
	 * 单个版面显示_框架页
	 */
	public ActionForward showMain(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("showMain");
	}

	/**
	 * 单个版面显示_顶部
	 */
	public ActionForward showTop(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String returnPath = ReturnPathUtils.makeReturnPathDefaultUseCurrentRequestURI(request, null);
		request.setAttribute("request_returnPath", returnPath);
		return mapping.findForward("showTop");
	}

	/**
	 * 单个版面显示_左侧_显示版面
	 */
	@SuppressWarnings("unchecked")
	public ActionForward showLeft(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, forum
		String id = request.getParameter("id");
		Forum forum = forumService.getById(id);
		request.setAttribute("request_forum", forum);

		// 2, categoryList
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);

		// 3, request_stickyTopicList 置顶贴列表
		CriteriaBean criteriaBean = new CriteriaBean()//
				.addRestriction(Restrictions.eq("forum", forum))//
				.addRestriction(Restrictions.eq("type", "置顶"))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("replyCount"));
		List stickyTopicList = topicService.getListByCriteriaBean(criteriaBean);
		request.setAttribute("request_stickyTopicList", stickyTopicList);

		// 4, 主题分页信息
		PageView pageView = topicService.getPageViewByCriteriaBean(createCriteriaBeanWithPageNumAndPageSize(request)//
				.addRestriction(Restrictions.eq("forum", forum))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("lastArticlePostTime"))// 按最后更新时间降序排列
				);
		request.setAttribute("request_pageView", pageView);

		return mapping.findForward("showLeft");
	}

	/**
	 * 单个版面显示_右侧_显示主题
	 */
	public ActionForward showRight(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String topicId = request.getParameter("topicId");
		if (StringUtils.isNotBlank(topicId)) {
			ActionForward af = mapping.findForward("showRight_showTopic");
			return new ActionForward(af.getPath() + "&id=" + topicId, af.getRedirect());
		} else {
			return mapping.findForward("showRight");
		}
	}
}
