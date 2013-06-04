package test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.jvwl.model.Department;
import com.jvwl.model.Student;

public class HibernateJPATest {
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new AnnotationConfiguration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	@Test
	public void test() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Department department = new Department();
		// ����java�е�UUID�����������ֵ
		department.setId(UUID.randomUUID().toString());
		department.setName("department");

		Student student = new Student();
		student.setName("stu1");
		student.setDepartment(department);

		Student student2 = new Student();
		student2.setName("stu1");
		student2.setDepartment(department);

		Set<Student> students = new HashSet<Student>();
		students.add(student);
		students.add(student2);
		department.setStudents(students);

		session.persist(department);
		session.getTransaction().commit();
		session.close();

	}

	@Test
	public void testFind() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Department department = (Department) session.load(Department.class,
				"72a86660-1780-458c-ab51-c7c7190c8b70");
		System.out.println(department.getName());
		Set<Student> students = department.getStudents();
		for (Student student : students) {
			System.out.println(student.getName());
			System.out.println(student.getName());
		}

		session.getTransaction().commit();
		session.close();

	}
}
