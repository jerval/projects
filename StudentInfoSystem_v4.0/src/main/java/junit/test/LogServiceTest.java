package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jvwl.model.Log;
import com.jvwl.service.LogService;

public class LogServiceTest {
	private static LogService logService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml", "beans.xml" });
		logService = (LogService) ctx
				.getBean("logService");
	}

	@Test
	public void testFinds() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		//map.put("id", "0785");
		//map.put("name", "07 ");
		List<Log> list = logService.findLogs(null, 1, 20).getList();
		for(Log log:list){
			System.out.println(log.getId());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add(1);
		ids.add(2);
		//ids.add("0706");
		logService.deleteLogs(ids);

	}
}
