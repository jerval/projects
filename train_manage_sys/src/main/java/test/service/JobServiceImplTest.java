package test.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.jvwl.train.common.PageInfo;
import com.jvwl.train.common.Pagination;
import com.jvwl.train.dto.JobDto;
import com.jvwl.train.model.Job;
import com.jvwl.train.service.JobService;
import com.jvwl.train.util.SpringUtils;

public class JobServiceImplTest {

	private static JobService jobService ;
	static{
		jobService = (JobService)SpringUtils.getBean("jobService");
	}
	@Test
	public void testFindEntitiesJobDtoPageInfo() {
		Pagination<Job> pagination = jobService.findObjects(new JobDto(), new PageInfo(1, 1));
		List<Job> list = pagination.getList();
		Long maxElements = pagination.getMaxElements();
		System.out.println(list);
	}

	@Test
	public void testFindEntitiesJobDtoPageInfoBoolean() {
		jobService.findObjects(new JobDto(), new PageInfo(1,1), false);
	}

	@Test
	public void testGetSqlWhere() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {

		Job job = new Job();
		job.setInsertUser("sdfo1");
		job.setJobId("123101");
		job.setJobName("departname1");
		job.setJobShortName("erfyer");
		job.setMemo(" not yet");
		job.setUpdateUser("got");
		jobService.save(job);
	}

	@Test
	public void testUpdate() {
		Job job =jobService.findClassById(1);
		//job.setId(1);// 一定要id
		job.setJobId("11111");
		job.setJobName("departnamdf");
		jobService.update(job);
	}

	@Test
	public void testDelete() {
		jobService.delete(new Integer[]{3});
		
	}

	@Test
	public void testFindAll() {
		List<Job> list = jobService.findAll(false);
		System.out.println(list);
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
