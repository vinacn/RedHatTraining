package com.instagrocer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.business.ItemBean;
import com.instagrocer.dao.ItemDAOWrapper;
import com.instagrocer.entity.ItemEntity;
@Component
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDAOWrapper itemDAOWrapper;

	@Override
	public ItemEntity addItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
		return itemDAOWrapper.addItem(itemBean);
	}

	@Override
	public ItemEntity getItemById(int stuId) {
		// TODO Auto-generated method stub
		return itemDAOWrapper.getItemById(stuId);
	}

	@Override
	public List<ItemBean> getAllItems() {
		// TODO Auto-generated method stub
		return itemDAOWrapper.getAllItems();
	}

	@Override
	public ItemEntity deleteItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
		return itemDAOWrapper.deleteItem(itemBean);
	}

}
