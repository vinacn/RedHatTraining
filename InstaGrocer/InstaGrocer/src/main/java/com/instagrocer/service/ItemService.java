package com.instagrocer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.instagrocer.business.ItemBean;
import com.instagrocer.entity.ItemEntity;

public interface ItemService {
	
	public ItemEntity addItem(ItemBean itemBean);
	public ItemEntity getItemById(int stuId);
	public List<ItemBean> getAllItems();
	public ItemEntity deleteItem(ItemBean itemBean);
}
