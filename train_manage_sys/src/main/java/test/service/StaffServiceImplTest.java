package test.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.StaffDto;
import com.jvwl.train.model.Staff;
import com.jvwl.train.model.ToEmployInfo;
import com.jvwl.train.service.JobService;
import com.jvwl.train.service.StaffService;
import com.jvwl.train.service.ToEmployInfoService;
import com.jvwl.train.util.SpringUtils;

public class StaffServiceImplTest {

	private static StaffService staffService ;
	private static JobService jobService ;
	private static ToEmployInfoService toEmployInfoService ;
	static{
		staffService = (StaffService)SpringUtils.getBean("staffService");
		toEmployInfoService = (ToEmployInfoService)SpringUtils.getBean("toEmployInfoService");
	}
	@Test
	public void testFindEntitiesStaffDtoPageInfo() {
		Pagination<Staff> pagination = staffService.findObjects(new StaffDto(), new PageInfo(1, 1));
		List<Staff> list = pagination.getList();
		Long maxElements = pagination.getMaxElements();
		System.out.println(list);
	}

	@Test
	public void testFindEntitiesStaffDtoPageInfoBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSqlWhere() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Staff staff = new Staff();
		staff.setUserId("123123");
		staff.setAddress("咸阳稀饭");
		staff.setAlamName("xianyang");
		staff.setUserName("departname");
		staff.setEmail("sldk@dkf.com");
		staff.setPassword("000");
		staff.setPostCode("628026");
		staff.setUserChinaname("搞回");
		staff.setUserId("100001");
		staff.setUserNumber("2005601");
		ToEmployInfo toEmployInfo=new ToEmployInfo();
		toEmployInfo.setBirthday(new Date());
		toEmployInfoService.save(toEmployInfo);
		staff.setToEmployee(new ToEmployInfo());
		staffService.save(staff);
	}

	@Test
	public void testUpdate() {
		Staff staff = new Staff();
		staff.setId(1);// 一定要id
		staff.setUserId("1111112");
		staff.setUserName("departname2");
		staffService.update(staff);
	}

	@Test
	public void testDelete() {
		staffService.delete(new Integer[]{1,2});
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
