package com.instagrocer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.entity.OrderItem;
@Component
public class OrderItemDAOWrapper {
	
	@Autowired
	private OrderItemDAO orderItemDAO;
	
	public OrderItem addOrderItem(OrderItem orderItems) {
		return orderItemDAO.save(orderItems);
	}

}
