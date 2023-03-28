package com.instagrocer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.instagrocer.entity.ItemEntity;

@Transactional
public interface ItemDAO extends CrudRepository<ItemEntity, Integer>{
	
	

}
