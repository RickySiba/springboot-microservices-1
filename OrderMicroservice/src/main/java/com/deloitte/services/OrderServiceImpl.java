package com.deloitte.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.dao.OrderRepository;
import com.deloitte.models.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer id) {
		Order orderFromDb = this.orderRepository.findByOrderId(id);
		return orderFromDb;
	}

	@Override
	public Order addOrder(Order order) {
		Order savedOrder = this.orderRepository.save(order);
		return savedOrder;
	}

}
