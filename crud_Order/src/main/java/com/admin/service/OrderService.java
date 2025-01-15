package com.admin.service;

import java.util.List;

import com.admin.model.Order;

public interface OrderService {

	
	public List<Order> getAllOrders();
	public Order getOrdersById(int id);
	public Order postOrders(Order order);
	public void deleteOrder(int id);
}
