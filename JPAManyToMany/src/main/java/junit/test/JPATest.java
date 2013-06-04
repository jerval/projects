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
	 * 向数据库中放入学生和老师的信息
	 */
@Test public void addInfo(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em =factory.createEntityManager();
	em.getTransaction().begin();
	em.persist(new Teacher("李老师"));
	em.persist(new Student("蹇伟"));
	em.persist(new Teacher("王老师"));
	em.persist(new Student("蹇洁"));
	em.getTransaction().commit();
	em.close();
	factory.close();
}
/*
 * 建立老师和学生的关系
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
 * 解除老师和学生的关系
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
 * 删除老师
 * 注：此方法不能删除老师和学生的关系
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
 * 删除学生
 * 注：此方法能删除学生和老师的关系
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
