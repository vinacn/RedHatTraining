package com.instagrocer.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.instagrocer.entity.OrderItem;


public interface OrderItemService {
	OrderItem create(@NotNull(message = "The items for order cannot be null.") @Valid OrderItem orderItem);
}
