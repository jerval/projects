package cn.itcast.bbs.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import cn.itcast.bbs.domain.BlogLink;
import cn.itcast.bbs.domain.Category;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.query.CriteriaBean;
import cn.itcast.bbs.web.struts.action.base.ActionBase;

@Controller("/portal")
public class PortalAction extends ActionBase {

	// FIXME  显示的数据的数量应能调整。在主页中显示数据的div块应可以配置。
	/** 网站主页 */
	public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1, request_blogLinkList
		List<BlogLink> blogLinkList = blogLinkService.findAll();
		request.setAttribute("request_blogLinkList", blogLinkList);

		// 2, request_topNewsList
		List<Topic> topNewsList = topicService.getListByCriteriaBean(new CriteriaBean()//
				.addRestriction(Restrictions.eq("type", "头条"))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("replyCount"))//
				.setFirstResult(0)//
				.setMaxResults(3)); // 只取3个
		request.setAttribute("request_topNewsList", topNewsList);

		// 3, request_categoryList
		List<Category> categoryList = categoryService.findAll();
		request.setAttribute("request_categoryList", categoryList);

		// 4, request_announceTopicList 公告
		List<Topic> announceTopicList = topicService.getListByCriteriaBean(new CriteriaBean()//
				.addRestriction(Restrictions.eq("type", "公告"))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("postTime"))// 最新的公告
				.setFirstResult(0)//
				.setMaxResults(11)); // 只取11个，因为只有11个的显示空间
		request.setAttribute("request_announceTopicList", announceTopicList);

		// 5, request_essenceTopicList 精华
		List<Topic> essenceTopicList = topicService.getListByCriteriaBean(new CriteriaBean()//
				.addRestriction(Restrictions.eq("type", "精华"))//
				.addRestriction(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("replyCount"))//
				.setFirstResult(0)//
				.setMaxResults(30)); // 显示30个精华贴
		request.setAttribute("request_essenceTopicList", essenceTopicList);

		return mapping.findForward("index");
	}

}
