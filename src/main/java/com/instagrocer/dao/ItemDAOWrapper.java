package com.instagrocer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.instagrocer.business.ItemBean;
import com.instagrocer.entity.ItemEntity;

@Component
public class ItemDAOWrapper {
	
	@Autowired
	private ItemDAO itemDao;
	
	private ItemEntity convertBeanToEntity(ItemBean itemBean)
	{
		ItemEntity entity=new ItemEntity();
		BeanUtils.copyProperties(itemBean, entity);
		return entity;
		
	}
	private ItemBean convertEntityToBean(ItemEntity itemEntity)
	{
		ItemBean bean=new ItemBean();
		BeanUtils.copyProperties(itemEntity, bean);
		return bean;
	}
	
	public ItemEntity addItem(ItemBean itemBean)
	{
		ItemEntity entity =convertBeanToEntity(itemBean);
		entity=itemDao.save(entity);
		/*Map<String,String> customRes = new HashMap<String,String>();
		customRes.put("itemId", entity.getItemId()+"");
		customRes.put("title", entity.getTitle());
		customRes.put("status", "added");*/
		return entity;
	}
	
	public ItemEntity getItemById(int stuId) {
		ItemEntity entity = null;
		Optional<ItemEntity> oEntity = itemDao.findById(stuId);
		if(oEntity!=null) {
			entity = oEntity.get();
		}
		return entity;
	}
	
	public List<ItemBean> getAllItems() {
		List<ItemBean> itemList = new ArrayList<ItemBean>();
		Iterable<ItemEntity> entities = itemDao.findAll();
		for(ItemEntity entity: entities) {
			ItemBean bean = convertEntityToBean(entity);
			itemList.add(bean);
		}
		return itemList;
	}
	
	public ItemEntity deleteItem(ItemBean itemBean)
	{
		ItemEntity entity =convertBeanToEntity(itemBean);
		itemDao.delete(entity);
		return entity;
	}
}
