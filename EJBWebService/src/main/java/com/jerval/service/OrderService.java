package com.jerval.service;

import java.util.List;

import com.jerval.bean.Order;

public interface OrderService {

	public String findUserName(String name);

	public Order findOrder(String orderId);

	public List<Order> findOrders(Integer pageNo, Integer pageSize);
}
