package cn.itcast.bbs.dao.base;

import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.bbs.dd.DataItem;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.test.base.TestBase;

public class DaoImplBaseTest extends TestBase {

	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		DataItem di = new DataItem();
		di.setId("xxx");// generator=uuid，会忽略掉设置的主键
		di.setName("test");
		session.save(di);

		tx.commit();
		session.close();
	}

	@Test
	public void testIncrementSerializableString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCriteriaBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxValue() {
		// ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		// UserService userService = (UserService) ac.getBean("userService");
		// int count = userService.getMaxValue("topicCount");
		// System.out.println(count);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testCriteria() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		DetachedCriteria dc = DetachedCriteria.forEntityName(User.class.getName());
		dc.createCriteria("roles").add(Restrictions.eq("name", "管理员"));

		List list = dc.getExecutableCriteria(session)//
				.add(Restrictions.like("loginName", "%a%"))//
				.list();

		System.out.println(list);

		tx.commit();
		session.close();
	}
}
