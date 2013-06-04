package test;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jerval.bean.Teacher;
import com.jerval.service.TeacherService;

public class TeacherServiceTest {

	private static TeacherService teacherService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			// 默认会到类路径下寻找名字为jndi的属性文件
			InitialContext initialContext = new InitialContext();
			teacherService = (TeacherService) initialContext
					.lookup("TeacherServiceBean/remote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		teacherService.save(new Teacher("测试"));
	}

	@Test
	public void testUpdate() {
		Teacher teacher = teacherService.findTeacher(12);
		teacher.setName("峡测试");
		teacherService.update(teacher);
	}

	@Test
	public void testDelete() {
		teacherService.delete(13);
	}

	@Test
	public void testFindTeacher() {
		System.out.println(teacherService.findTeacher(12));
	}

	@Test
	public void testFindTeachers() {
		System.out.println(teacherService.findTeachers(1, 4));
	}

}
