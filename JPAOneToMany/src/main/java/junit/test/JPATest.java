package junit.test;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import com.jvwl.model.Order;
import com.jvwl.model.OrderItem;


public class JPATest {
@Test public void test(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	
	Order order = new Order();
	order.setAmount(108f);
	order.setOrderId(UUID.randomUUID().toString());
	
	OrderItem orderItem1 = new OrderItem();
	orderItem1.setOrder(order);
	orderItem1.setProductName("kk");
	orderItem1.setSellPrice(24f);
	order.addOrderItem(orderItem1);
	
	OrderItem orderItem2 = new OrderItem();
	orderItem2.setOrder(order);
	orderItem2.setProductName("ooo");
	orderItem2.setSellPrice(222f);
	order.addOrderItem(orderItem2);
	
	em.persist(order);
	em.getTransaction().commit();
	em.close();	
	factory.close();
}
@SuppressWarnings("unchecked")
@Test public void testQuery(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jvwl");
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	
	List<Order> list = em.createQuery("select o from Order o").getResultList();
	for(Order o :list){
		System.out.println(o.getOrderId());
		System.out.println(o.getItems().size());
	}
	em.getTransaction().commit();
	em.close();	
	factory.close();
}
}
