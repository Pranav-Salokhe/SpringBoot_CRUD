package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.OrderDTO;
import com.admin.model.Order;
import com.admin.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public ResponseEntity<List<Order>> getAllOrderData(){
		List<Order> order = orderService.getAllOrders();
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable("id") int id){
		Order order = orderService.getOrdersById(id);
		if(order==null) {
			return new ResponseEntity<>(order,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Order> postOrderData(@RequestBody OrderDTO orderDTO){
		Order order = new Order();
		order.setName(orderDTO.getName());
		order.setAddress(orderDTO.getAddress());
		order.setAmount(orderDTO.getAmount());
		order.setBillAmount(orderDTO.getBillAmount());
		order.setEventDate(orderDTO.getEventDate());
		order.setMobileNumber(orderDTO.getMobileNumber());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setQuantity(orderDTO.getQuantity());
		order.setStatus(orderDTO.getStatus());
		
		Order insertedData = orderService.postOrders(order);
		return new ResponseEntity<>(insertedData,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> putOrderData(@PathVariable("id") int id, @RequestBody OrderDTO orderDTO){
		
		Order existingOrder = orderService.getOrdersById(id);
		if(existingOrder == null) {
			return new ResponseEntity<>(existingOrder,HttpStatus.NOT_FOUND);
		}
		existingOrder.setName(orderDTO.getName());
		existingOrder.setAddress(orderDTO.getAddress());
		existingOrder.setAmount(orderDTO.getAmount());
		existingOrder.setBillAmount(orderDTO.getBillAmount());
		existingOrder.setEventDate(orderDTO.getEventDate());
		existingOrder.setMobileNumber(orderDTO.getMobileNumber());
		existingOrder.setOrderDate(orderDTO.getOrderDate());
		existingOrder.setQuantity(orderDTO.getQuantity());
		existingOrder.setStatus(orderDTO.getStatus());

		Order updatedData = orderService.postOrders(existingOrder);
		return new ResponseEntity<>(updatedData,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrderData(@PathVariable("id") int id){
		Order existingOrder = orderService.getOrdersById(id);
		if(existingOrder==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		orderService.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
}
