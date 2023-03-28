package com.instagrocer.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.instagrocer.entity.OrderItem;
import com.instagrocer.entity.OrderItemPK;

@Transactional
public interface OrderItemDAO extends CrudRepository<OrderItem, OrderItemPK> {

}
