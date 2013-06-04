package test.service;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.jvwl.train.service.DepartmentService;
import com.jvwl.train.util.SpringUtils;

public class ToEmployTestInfoServiceImplTest {

	private static DepartmentService departmentService ;
	static{
		departmentService = (DepartmentService)SpringUtils.getBean("departmentService");
	}
	@Test
	public void testFindEntitiesDepartmentDtoPageInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEntitiesDepartmentDtoPageInfoBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSqlWhere() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindClassByIdSerializable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIds() {
		fail("Not yet implemented");
	}

}
