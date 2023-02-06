package com.deloitte.services;

import java.util.List;

import com.deloitte.models.Order;

public interface OrderService {
	public List<Order> getOrders();
	public Order getOrderById(Integer id);
	public Order addOrder(Order order);
}
