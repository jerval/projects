package cn.itcast.bbs.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.bbs.dd.DDConstants;
import cn.itcast.bbs.dd.DataDict;
import cn.itcast.bbs.domain.Gender;
import cn.itcast.bbs.utils.CompassUtils;
import cn.itcast.bbs.utils.converter.beanutils.GenericEnumConverter;
import cn.itcast.bbs.utils.converter.beanutils.UtilDateConverter;

@SuppressWarnings("serial")
public class InitSystemServlet extends GenericServlet {
	private Log log = LogFactory.getLog(InitSystemServlet.class);

	@SuppressWarnings("unchecked")
	@Override
	public void init() throws ServletException {
		// 注册转换器
		ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
		ConvertUtils.register(new GenericEnumConverter(Gender.class), Gender.class);
		log.info("已注册转换器：UtilDateConverter 与 new GenericEnumConverter(Gender.class)");

		// 初始化数据字典
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		DataDict.initialize(sessionFactory);

		// 初始化CompassUtils
		String applicationRealPath = getServletContext().getRealPath("/"); // 返回的目录将以'/'结尾
		CompassUtils.init(applicationRealPath);

		// FIXME 准备application中的数据。放到一个专门的类中?
		List topicTypeList = DataDict.getList(DDConstants.TOPIC_TYPE);
		getServletContext().setAttribute(WebConstants.APPLICATION_TOPIC_TYPE_LIST, topicTypeList);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		throw new UnsupportedOperationException();
	}

}
