package com.deloitte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.models.Order;
import com.deloitte.models.User;
import com.deloitte.models.DTO.OrderDTO;
import com.deloitte.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderService orderService;
	private final RestTemplate restTemplate;
	
	@Autowired
	public OrderController(OrderService orderService, RestTemplate restTemplate) {
		this.orderService = orderService;
		this.restTemplate = restTemplate;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = this.orderService.getOrders();
		System.out.println(orders);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Integer id) {
		Order order = this.orderService.getOrderById(id);
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setCustomerId(order.getCustomerId());
		orderDTO.setTotalOrderAmount(order.getTotalOrderAmount());
		orderDTO.setOrderStatus(order.getOrderStatus());
		orderDTO.setOrderDate(order.getOrderDate());
		orderDTO.setShippedDate(order.getShippedDate());
		orderDTO.setDeliveredDate(order.getDeliveredDate());
		orderDTO.setReturnDate(order.getReturnDate());
		
		// fetching user details from user microservice
		User user = restTemplate.getForObject("http://localhost:8080/users/"+order.getCustomerId(), User.class);
		
		orderDTO.setUser(user);
		
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order savedOrder = this.orderService.addOrder(order);
		return ResponseEntity.ok(savedOrder);
	}
}
