package com.instagrocer.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.instagrocer.business.ItemBean;

public class OrderItemPK implements Serializable{
	
	 @JsonBackReference
	 @ManyToOne(optional = false, fetch = FetchType.LAZY)
	 @JoinColumn(name = "orderid")
	 private OrderEntity order;

	 @ManyToOne(optional = false, fetch = FetchType.LAZY)
	 @JoinColumn(name = "itemid")
	 private ItemEntity item;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}	 

}
