package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jvwl.model.Clazz;
import com.jvwl.model.Grade;
import com.jvwl.service.ClazzService;

public class ClazzServiceTest {
	private static ClazzService clazzService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml", "beans.xml" });
		clazzService = (ClazzService) ctx
				.getBean("clazzService");
	}

	@Test
	public void testAdd() {
		Clazz clazz = new Clazz();
		clazz.setClassId("0755");
		Grade grade = new Grade();
		grade.setGradeId("0703");
		clazz.setGrade(grade);
		clazz.setName("07软件");
		clazzService.addClazz(clazz, "jjj");
	}
	@Test
	public void testFind() {
		Clazz clazz = clazzService.findClazz("0755");
		System.out.println(clazz.getName());
	}
	@Test
	public void testFinds() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "0755");
		//map.put("name", "07 ");
		List<Clazz> list = clazzService.findClazzs(map, 1, 20).getList();
		for(Clazz clazz:list){
			System.out.println(clazz.getName());
		}
	}
	@Test
	public void testUpdate() {
		Clazz clazz = clazzService.findClazz("0755");
		clazz.setName("08");
		clazzService.updateClazz(clazz, "aaaa");
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add("0755");
		//ids.add("0706");
		clazzService.deleteClazz(ids, "llll");

	}
}
