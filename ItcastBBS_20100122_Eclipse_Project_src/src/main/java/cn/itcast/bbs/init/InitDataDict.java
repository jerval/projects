package cn.itcast.bbs.init;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bbs.dd.DDConstants;
import cn.itcast.bbs.dd.DataItem;

/**
 * 应读取 xml 文件进行初始化。
 * 
 * @author tyg
 */
public class InitDataDict {

	@Test
	public void init() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// 先删除所有的数据项
		session.createQuery("DELETE FROM DataItem").executeUpdate();

		// 添加数据项
		// config
		session.save(new DataItem(DDConstants.LOGIN_USER_URL, "/user.do?method=loginUI", String.class, false));
		session.save(new DataItem(DDConstants.DEFAULT_PAGE_SIZE, "50", Integer.class, false));
		session.save(new DataItem(DDConstants.DISPALY_PAGE_NUMBER_COUNT, "10", Integer.class, false));

		// topic type
		session.save(new DataItem(DDConstants.TOPIC_TYPE, "普通", String.class, false));
		// session.save(new DataItem(DDConstants.TOPIC_TYPE, "提问", String.class, false));
		// session.save(new DataItem(DDConstants.TOPIC_TYPE, "团报", String.class, false));
		session.save(new DataItem(DDConstants.TOPIC_TYPE, "置顶", String.class, false));
		session.save(new DataItem(DDConstants.TOPIC_TYPE, "公告", String.class, false));
		session.save(new DataItem(DDConstants.TOPIC_TYPE, "头条", String.class, false));
		session.save(new DataItem(DDConstants.TOPIC_TYPE, "精华", String.class, false));

		// privilege - resource
		session.save(new DataItem(DDConstants.PRIVILEGE_SYSTEM_RESOURCE, "Topic", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_SYSTEM_RESOURCE, "Reply", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_SYSTEM_RESOURCE, "Attachment", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_SYSTEM_RESOURCE, "Poll", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_SYSTEM_RESOURCE, "System", String.class, false));
		// privilege - action
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Create", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Retrieval", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Delete", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Update", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Move", String.class, false)); // 移动主题
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Download", String.class, false));
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Vote", String.class, false));// 参与投票
		session.save(new DataItem(DDConstants.PRIVILEGE_RESOURCE_ACTION, "Manage", String.class, false));// 系统管理

		// system log type
		session.save(new DataItem(DDConstants.SYSTEM_LOG_TYPE, "移动主题", String.class, false));// 系统管理
		session.save(new DataItem(DDConstants.SYSTEM_LOG_TYPE, "删除主题", String.class, false));// 系统管理
		session.save(new DataItem(DDConstants.SYSTEM_LOG_TYPE, "删除回复", String.class, false));// 系统管理
		session.save(new DataItem(DDConstants.SYSTEM_LOG_TYPE, "系统管理操作信息", String.class, false));// 系统管理
		
		// log manage trace
		session.save(new DataItem(DDConstants.MANAGE_METHOD_NAME_REGEX_TO_EXCLUDE_LOG_TRACE, "list", String.class, false));// 系统管理
		session.save(new DataItem(DDConstants.MANAGE_METHOD_NAME_REGEX_TO_EXCLUDE_LOG_TRACE, ".*UI", String.class, false));// 系统管理

		tx.commit();
		session.close();
	}
}
