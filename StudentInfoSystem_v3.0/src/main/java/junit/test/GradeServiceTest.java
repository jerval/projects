package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.model.Department;
import com.jvwl.model.Grade;
import com.jvwl.service.GradeService;

public class GradeServiceTest {
	private static GradeService gradeService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml", "beans.xml" });
		gradeService = (GradeService) ctx
				.getBean("gradeService");
	}

	@Test
	public void testAdd() {
		Grade grade = new Grade();
		grade.setGradeId("0707");
		Department department = new Department();
		department.setDepartmentId("0738");
		grade.setDepartment(department);
		grade.setName("07软件");
		gradeService.addGrade(grade, "jjj");

	}
	@Test
	public void testFind() {
		Grade grade = gradeService.findGrade("0705");
		System.out.println(grade.getName());
	}
	@Test
	public void testFinds() {
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("id", "0705");
		map.put("name", "07 ");
		List<Grade> list = gradeService.findGrades(map, 1, 20).getList();
		for(Grade grade:list){
			System.out.println(grade.getName());
		}
	}
	@Test
	public void testUpdate() {
		Grade grade = gradeService.findGrade("0705");
		grade.setName("08");
		gradeService.updateGrade(grade, "aaaa");

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add("0705");
		ids.add("0706");
		gradeService.deleteGrade(ids, "llll");

	}
}
