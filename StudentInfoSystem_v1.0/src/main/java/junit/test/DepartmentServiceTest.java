package junit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.bean.Pagination;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;

public class DepartmentServiceTest {
	private static DepartmentService departmentService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml", "beans.xml" });
		departmentService = (DepartmentService) ctx
				.getBean("departmentService");
	}

	@Test
	public void testAdd() {
		Department department = new Department();
		department.setDepartmentId("0738");
		department.setName("商贸系");
		departmentService.addDepartment(department, "jjj");

	}
	@Test
	public void testFind() {
		Department department = departmentService.findDepartment("0738");
		System.out.println(department.getName());
	}
	@Test
	public void testFinds() {
		Pagination<Department> pagination = departmentService.findDepartments(null, 1, 20);
		List<Department> list = pagination.getList();
		System.out.println(pagination.getMaxElements());
		for(Department department:list){
			System.out.println(department.getName()+department.getDepartmentId());
		}
	}
	@Test
	public void testUpdate() {
		Department department = departmentService.findDepartment("0736");
		department.setName("计算机系");
		departmentService.updateDepartment(department, "aaaa");

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add("0734");
		departmentService.deleteDepartment(ids, "llll");

	}
}
