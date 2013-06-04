package cn.itcast.bbs.dd;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.bbs.test.base.TestBase;

public class DataDictTest extends TestBase {

	@BeforeClass
	public static void testInitialize() {
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		DataDict.initialize(sessionFactory);
	}

	@Test
	public void testGetString() {
		String loginUserUrl = DataDict.getString(DDConstants.LOGIN_USER_URL);
		System.out.println(DDConstants.LOGIN_USER_URL + " = " + loginUserUrl);
	}

	@Test
	public void testGetInt() {
		int pageSize = DataDict.getInt(DDConstants.DEFAULT_PAGE_SIZE);
		System.out.println(DDConstants.DEFAULT_PAGE_SIZE + " = " + pageSize);
	}

	@Test
	public void testGetObject() {
		// User user = (User) DataDict.getObject("user1");
		// System.out.println(user);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testGetList() {
		List list = (List) DataDict.getObject(DDConstants.TOPIC_TYPE);
		System.out.println(list);
	}
}
