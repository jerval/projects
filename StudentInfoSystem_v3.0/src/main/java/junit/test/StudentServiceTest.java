package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jvwl.model.Clazz;
import com.jvwl.model.Student;
import com.jvwl.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml", "beans.xml" });
		studentService = (StudentService) ctx
				.getBean("studentService");
	}

	@Test
	public void testAdd() {
		Student student = new Student();
		student.setStudentId("0786");
		Clazz clazz = new Clazz();
		clazz.setClassId("0755");
		student.setClazz(clazz);
		student.setName("aaa");
		studentService.addStudent(student, "jjj");
	}
	@Test
	public void testFind() {
		Student student = studentService.findStudent("0785");
		System.out.println(student.getGender());
	}
	@Test
	public void testFinds() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "0785");
		//map.put("name", "07 ");
		List<Student> list = studentService.findStudents(map, 1, 20).getList();
		for(Student student:list){
			System.out.println(student.getName());
		}
	}
	@Test
	public void testUpdate() {
		Student student = studentService.findStudent("0785");
		student.setName("08");
		studentService.updateStudent(student, "sss");
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add("0785");
		//ids.add("0706");
		studentService.deleteStudent(ids, "llll");

	}
}
