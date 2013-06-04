package cn.itcast.bbs.search;

import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.query.QueryResult;
import cn.itcast.bbs.search.base.GenericIndexDao;
import cn.itcast.bbs.test.base.TestBase;

public class TopicIndexDaoImplTest extends TestBase {

	private GenericIndexDao<SearchableTopic> indexDao = new TopicIndexDaoImpl();

	@SuppressWarnings("unchecked")
	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Topic> topicList = session.createCriteria(Topic.class).list();
		for (Topic topic : topicList) {
			SearchableTopic st = new SearchableTopic(topic);
			indexDao.save(st);
		}

		tx.commit();
		session.close();
	}

	@Test
	public void testSearch() {
		String queryString = "google";
		QueryResult<SearchableTopic> qr = indexDao.search(queryString, 0, 100);
		System.out.println("-----> total: " + qr.getRecordCount());
		System.out.println("-----> list :");
		for (SearchableTopic st : qr.getRecordList()) {
			System.out.println(st);
		}
	}

	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

}
