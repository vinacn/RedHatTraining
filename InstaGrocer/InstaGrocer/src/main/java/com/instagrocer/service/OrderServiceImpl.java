package com.instagrocer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.business.OrderBean;
import com.instagrocer.dao.OrderDAOWrapper;
import com.instagrocer.entity.OrderEntity;
@Component
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDAOWrapper orderDAOWrapper;
	
	@Override
	public OrderEntity placeOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		return orderDAOWrapper.placeOrder(order);
	}

	@Override
	public OrderEntity getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderDAOWrapper.getOrderById(orderId);
	}

	@Override
	public OrderEntity updateOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		return orderDAOWrapper.updateOrder(order);
	}

}
