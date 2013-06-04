package com.jvwl;

import static org.junit.Assert.fail;

import java.io.Serializable;
import java.util.Date;

import org.junit.Test;

import com.jvwl.dto.PageInfo;
import com.jvwl.model.Department;
import com.jvwl.service.DepartmentService;

public class TestDepartmentService {
	private DepartmentService departmentService = new DepartmentService();

	@Test
	public void testFindByDepartId() {
		System.out.println(departmentService.findByDepartId("201112"));
	}

	@Test
	public void testFindDepartments() {
		departmentService.findDepartments(null, new PageInfo(1, 10));
	}

	@Test
	public void testAdd() {
		Department department = new Department();
		department.setDateCreated(new Date());
		department.setDepart_id("2011");
		department.setDepart_name("lll");
		department.setDepart_info("info");
		departmentService.add(department);
	}

	@Test
	public void testUpdate() {
		//Department department = departmentService.find(Department.class, 1);
		Department department = new Department();
		department.setId(2);
		department.setVersion(0);
		department.setDepart_id("2011126");
		department.setDepart_name("ll222");
		department.setDepart_info("info");
		departmentService.update(department);
	}

	@Test
	public void testDeleteT() {
		Department department = new Department();
		department.setId(1);
		departmentService.delete(departmentService.find(Department.class, 1));
	}

	@Test
	public void testDeleteClassOfTSerializableArray() {
		departmentService.delete(Department.class, new Serializable[]{2});
	}

	@Test
	public void testExecuteUpdate() {
		String hql = "delete from Department where id=?";
		System.out.println(departmentService.executeUpdate(hql, 3));
	}

	@Test
	public void testFind() {
		System.out.println(departmentService.find(Department.class, 1));
	}

	@Test
	public void testFindClass() {
		System.out.println(departmentService.findClass(Department.class, 2));
	}

	@Test
	public void testGetTotalElements() {
		System.out.println(departmentService.getTotalElements("select count(*) from Department d where id>?",1));
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

}
