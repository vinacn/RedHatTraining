package com.instagrocer.service;

import com.instagrocer.business.OrderBean;
import com.instagrocer.entity.OrderEntity;

public interface OrderService {
	public OrderEntity placeOrder(OrderEntity order);
	public OrderEntity getOrderById(int orderId);
	public OrderEntity updateOrder(OrderEntity order);
}
