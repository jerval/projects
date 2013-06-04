package cn.itcast.bbs.test.base;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bbs.dd.DataDict;
import cn.itcast.bbs.utils.CompassUtils;

public class TestBase {

	protected static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
	protected static SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");

	static {
		// 初始化数据字典
		DataDict.initialize(sessionFactory);
		System.out.println("---> init DataDict");

		// 初始化CompassUtils
		// CompassUtils.init("c:/appPath/");
		CompassUtils
				.init("G:\\Workspace\\EclipseProjects\\.metadata\\.plugins\\com.genuitec.eclipse.easie.tomcat.myeclipse\\tomcat\\webapps\\ItcastBBS\\");
	}
}
