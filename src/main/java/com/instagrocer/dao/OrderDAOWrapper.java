package com.instagrocer.dao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.business.OrderBean;
import com.instagrocer.entity.ItemEntity;
import com.instagrocer.entity.OrderEntity;

@Component
public class OrderDAOWrapper {
	@Autowired
	private OrderDAO orderDao;
	
	private OrderEntity convertBeanToEntity(OrderBean orderBean)
	{
		OrderEntity entity=new OrderEntity();
		BeanUtils.copyProperties(orderBean, entity);
		return entity;
		
	}
	private OrderBean convertEntityToBean(OrderEntity orderEntity)
	{
		OrderBean bean=new OrderBean();
		BeanUtils.copyProperties(orderEntity, bean);
		return bean;
	}
	
	public OrderEntity placeOrder(OrderEntity orderBean)
	{
		//OrderEntity entity =convertBeanToEntity(orderBean);
		OrderEntity entity=orderDao.save(orderBean);
		/*Map<String,String> customRes = new HashMap<String,String>();
		customRes.put("itemId", entity.getItemId()+"");
		customRes.put("title", entity.getTitle());
		customRes.put("status", "added");*/
		return entity;
	}
	
	public OrderEntity updateOrder(OrderEntity orderBean)
	{
		//OrderEntity entity =convertBeanToEntity(orderBean);
		
		OrderEntity entity=orderDao.save(orderBean);
		/*Map<String,String> customRes = new HashMap<String,String>();
		customRes.put("itemId", entity.getItemId()+"");
		customRes.put("title", entity.getTitle());
		customRes.put("status", "added");*/
		return entity;
	}
	
	public OrderEntity getOrderById(int orderid)
	{
		OrderEntity entity = null;
		Optional<OrderEntity> oEntity = orderDao.findById(orderid);
		if(oEntity!=null) {
			entity = oEntity.get();
		}
		return entity;
	}
	
}
