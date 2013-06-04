package junit.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.jvwl.model.Department;
import com.jvwl.model.Employee;
import com.jvwl.model.Sells;
import com.jvwl.model.Skiller;

public class JPATest {
@Test public void testInheritance(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager manager = factory.createEntityManager();
	manager.getTransaction().begin();
	
	Department department = new Department();
	department.setName("department");
	
	Employee emp1 = new Employee();
	emp1.setName("emp1");
	emp1.setDepartment(department);
	
	Sells emp2 = new Sells();
	emp2.setName("emp2");
	emp2.setDepartment(department);
	emp2.setSell(2222);
	
	Skiller emp3 = new Skiller();
	emp3.setName("emp3");
	emp3.setDepartment(department);
	emp3.setSkill("skill");
	
	Set<Employee> employees = new HashSet<Employee>();
	employees.add(emp1);
	employees.add(emp2);
	employees.add(emp3);
	department.setEmployees(employees);
	
	manager.persist(department);
	manager.getTransaction().commit();
}
}
