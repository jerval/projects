package test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.DepartmentDto;
import com.jvwl.train.model.Department;
import com.jvwl.train.service.DepartmentService;
import com.jvwl.train.util.SpringUtils;
/**
 * 
 * @author jerval
 *
 */
public class DepartmentServiceImplTest {

	private static DepartmentService departmentService;
	static {
		departmentService = (DepartmentService) SpringUtils
				.getBean("departmentService");
	}

	@Test
	public void testFindEntitiesDepartmentDtoPageInfo() {
		Pagination<Department> pagination = departmentService.findObjects(new DepartmentDto(), new PageInfo(1, 1));
		List<Department> list = pagination.getList();
		Long maxElements = pagination.getMaxElements();
		System.out.println(list);
	}

	@Test
	public void testFindEntitiesDepartmentDtoPageInfoBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSqlWhere() {
		departmentService.getSqlWhere(null);
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		
		Department department = new Department();
		department.setDepartmentId("123123");
		department.setDepartmentName("departname");
		departmentService.save(department);
		//throw new RuntimeException("test errro");
	}

	@Test
	public void testUpdate() {
		Department department = new Department();
		department.setId(1);// 一定要id
		department.setDepartmentId("1111112");
		department.setDepartmentName("departname2");
		departmentService.update(department);
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
		//departmentService.
		//fail("Not yet implemented");
	}

	@Test
	public void testFindClassByIdSerializable() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIds() {

	}

}
