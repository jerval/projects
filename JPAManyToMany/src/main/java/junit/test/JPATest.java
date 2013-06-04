package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.jvwl.model.Student;
import com.jvwl.model.Teacher;

public class JPATest {
	@Test public void makeTable(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
		factory.close();
	}
	/*
	 * �����ݿ��з���ѧ������ʦ����Ϣ
	 */
@Test public void addInfo(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	em.persist(new Teacher("����ʦ"));
	em.persist(new Student("�ΰ"));
	em.persist(new Teacher("����ʦ"));
	em.persist(new Student("忽�"));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
/*
 * ������ʦ��ѧ���Ĺ�ϵ
 */
@Test public void buidTS(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	Student student = em.find(Student.class, 1);
	student.addTeacher(em.getReference(Teacher.class, 1));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
/*
 * �����ʦ��ѧ���Ĺ�ϵ
 */
@Test public void removeTS(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	Student student = em.find(Student.class, 1);
	student.removeTeacher(em.getReference(Teacher.class, 1));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
/*
 * ɾ����ʦ
 * ע���˷�������ɾ����ʦ��ѧ���Ĺ�ϵ
 */
@Test public void removeTeacher(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	em.remove(em.getReference(Teacher.class, 1));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
/*
 * ɾ��ѧ��
 * ע���˷�����ɾ��ѧ������ʦ�Ĺ�ϵ
 */
@Test public void removeStudent(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	em.remove(em.getReference(Student.class, 1));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
}
