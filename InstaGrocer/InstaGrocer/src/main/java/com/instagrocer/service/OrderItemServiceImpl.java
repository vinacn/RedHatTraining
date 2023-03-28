package com.instagrocer.service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.dao.ItemDAOWrapper;
import com.instagrocer.dao.OrderItemDAOWrapper;
import com.instagrocer.entity.OrderItem;
@Component
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	private OrderItemDAOWrapper orderItemDAOWrapper;

	@Override
	public OrderItem create(@NotNull(message = "The items for order cannot be null.") @Valid OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemDAOWrapper.addOrderItem(orderItem);
	}
}
