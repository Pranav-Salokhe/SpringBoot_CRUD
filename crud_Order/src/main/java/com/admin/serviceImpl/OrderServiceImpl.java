package com.admin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Order;
import com.admin.repository.OrderRepository;
import com.admin.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.findAll();
		
	}

	@Override
	public Order getOrdersById(int id) {
		
		Order order = orderRepository.findById(id).orElse(null);
		return order;
	}

	@Override
	public Order postOrders(Order order) {
		return orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(int id) {
		
		orderRepository.deleteById(id);
		
	}

}
