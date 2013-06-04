package com.jerval.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.jerval.bean.Order;
import com.jerval.service.OrderService;

@WebService(targetNamespace = "http://ws.jerval.com", name = "OrderService", serviceName = "OrderServiceBean")
@Stateless
@Remote(OrderService.class)
public class OrderServiceBean implements OrderService {

	// @WebMethod//如果写了这个注解，那其它没有写这个注解的将不会暴露出来
	@Override
	public String findUserName(String name) {
		return "Hello:" + name;
	}

	@Override
	public Order findOrder(String orderId) {
		Order order = new Order(orderId, "测试订单");
		return order;
	}

	@Override
	public List<Order> findOrders(Integer pageNo, Integer pageSize) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("1", "aaa"));
		orders.add(new Order("2", "bbb"));
		orders.add(new Order("3", "ccc"));
		return orders;
	}

}
