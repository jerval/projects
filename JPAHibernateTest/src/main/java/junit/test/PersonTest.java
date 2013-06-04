package junit.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.jvwl.jpa.model.Person;
import com.jvwl.jpa.model.PersonGender;


public class PersonTest {
	/*
	 * ����ɾ���Ķ�����Ҫ������֧�֣�������ִ��
	 */
@Test public void save(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
		Person person = new Person();
		person.setId("aaa");
	person.setName("����");
	person.setPersonGender(PersonGender.WOMAN);
	person.setBirthday(new Date());
	person.setInfo("����һ�´��ı���ʽ�����ı���Ϣ");
	em.persist(person);
	em.getTransaction().commit();
	em.close();
	factory.close();
}
//�൱��Hibernate�е�get����
@Test public void find(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Person person = em.find(Person.class, 1);
	System.out.println(person.getName());
	em.getTransaction().commit();
	em.close();
	factory.close();
}
//�൱��Hibernate�е�load����
@Test public void reference(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Person person = em.getReference(Person.class, 1);
	System.out.println(person.getName());
	em.getTransaction().commit();
	em.close();
	factory.close();
}
@Test public void update(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Person person = em.find(Person.class, 1);
	person.setName("aaa");
	em.getTransaction().commit();
	em.close();
	factory.close();
}
@Test public void delete(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Person person = em.find(Person.class, 1);
	em.remove(person);
	em.getTransaction().commit();
	em.close();
	factory.close();
}
@SuppressWarnings("unchecked")
@Test public void query(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	/*����ռλ��ѯ���ʺź�����ֿ���ָ�������Ŀ�ʼ����
	Query query = em.createQuery("select o from Person o where id = ?100");
	query.setParameter(100, 2);
	*/
	/*���������ռ��ѯ*/
	//Query query = em.createQuery("select o from Person o where o.id = :id");
	Query query = em.createQuery("select o from Person o ");
	//query.setParameter("id", 1);
	//query.setParameter("name", 1);
	//Person person = (Person) query.getSingleResult();
	List<Person> persons = query.getResultList();
	for(Person person:persons ){
	System.out.println(person.getName());
	}
	//query = em.createQuery("select count(*) from Person");Ҳ����
	//query = em.createQuery("select count(o) from Person o where 1=1");
	//System.out.println(query.getSingleResult());
	em.close();
	factory.close();
}
@Test public void deleteQuery(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Query query = em.createQuery("delete from Person o where o.id = :id");
	query.setParameter("id", 3);
	query.executeUpdate();
	em.getTransaction().commit();
	em.close();
	factory.close();
}
@Test public void updateQuery(){
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	Query query = em.createQuery("update Person o set o.name=:name where o.id = :id");
	query.setParameter("name", "aaaa");
	query.setParameter("id", 2);
	query.executeUpdate();
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
