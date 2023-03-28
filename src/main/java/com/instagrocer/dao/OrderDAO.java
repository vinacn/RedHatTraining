package com.instagrocer.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.instagrocer.entity.OrderEntity;

@Transactional
public interface OrderDAO extends CrudRepository<OrderEntity, Integer> {
	
	

}
