package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.jvwl.model.IDCard;
import com.jvwl.model.Person;

public class JPATest {
@Test public void test(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Person person = new Person("¿œ’≈");
	person.setIdCard(new IDCard("12212121"));
	em.persist(person);
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
