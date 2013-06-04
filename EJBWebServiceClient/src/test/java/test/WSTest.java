package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jerval.ws.client.Order;
import com.jerval.ws.client.OrderService;
import com.jerval.ws.client.OrderServiceBean;

public class WSTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void findUserName() {
		OrderServiceBean serviceBean = new OrderServiceBean();
		OrderService service = serviceBean.getOrderServicePort();
		System.out.println(service.findUserName("jerval"));
	}

	@Test
	public void findOrder() {
		OrderServiceBean serviceBean = new OrderServiceBean();
		OrderService service = serviceBean.getOrderServicePort();
		Order order = service.findOrder("12");
		System.out.println(order);
	}

	@Test
	public void findOrders() {
		OrderServiceBean serviceBean = new OrderServiceBean();
		OrderService service = serviceBean.getOrderServicePort();
		List<Order> orders = service.findOrders(1, 10);
		System.out.println(orders);
	}

}
