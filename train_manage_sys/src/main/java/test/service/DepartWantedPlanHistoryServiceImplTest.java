package test.service;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.jvwl.train.service.DepartWantedPlanHistoryService;
import com.jvwl.train.util.SpringUtils;

public class DepartWantedPlanHistoryServiceImplTest {

	private static DepartWantedPlanHistoryService departWantedPlanHistoryService;
	static {
		departWantedPlanHistoryService = (DepartWantedPlanHistoryService) SpringUtils
				.getBean("departWantedPlanHistoryService");
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
