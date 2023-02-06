package com.deloitte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public Order findByOrderId(int id);
}
