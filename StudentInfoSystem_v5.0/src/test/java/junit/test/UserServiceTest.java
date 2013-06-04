package junit.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.bean.Pagination;
import com.jvwl.model.User;
import com.jvwl.model.UserType;
import com.jvwl.service.UserService;

public class UserServiceTest {
	private static UserService userService;
	static {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "beans.xml" });
		userService = (UserService) ctx.getBean("userService");
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setUsername("1");
		user.setPassword("1");
		user.setType(UserType.ADMIN);
		userService.addUser(user, "jjj");
	}
	@Test
	public void testFind() {
		User user = userService.findUser("ooo");
		System.out.println(user.getUsername());
	}
	@Test
	public void testFinds() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		//map.put("id", "0785");
		//map.put("name", "07 ");
		Pagination<User> pagination =userService.findUsers(null, 1, 20);
		List<User> list = pagination.getList();
		System.out.println(pagination.getMaxElements());
		for(User user:list){
			System.out.println(user.getUsername());
		}
	}
	@Test
	public void testUpdate() {
		User user = userService.findUser("ooo");
		user.setPassword("08");
		userService.updateUser(user, "sss");
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		List ids = new ArrayList();
		ids.add("ooo");
		//ids.add("0706");
		userService.deleteUser(ids, "llll");

	}
}
