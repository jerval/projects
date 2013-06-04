package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.jvwl.model.AirLine;

public class JPATest {
@Test public void test(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	em.persist(new AirLine("PEK", "SHA", "北京飞上海"));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
