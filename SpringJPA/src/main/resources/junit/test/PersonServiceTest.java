package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvwl.model.Person;
import com.jvwl.service.PersonService;

public class PersonServiceTest {
	private static PersonService personService;
	static {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			personService = (PersonService) context.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		personService.add(new Person("aaa"));
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {
		personService.delete(Person.class, 5);
	}

}
