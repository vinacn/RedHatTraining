package com.instagrocer.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem {

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK pk;

    @Column(nullable = false)
	private Integer quantity;

    // default constructor
    public OrderItem() {
    	
    }
    

    public OrderItem(OrderEntity order, ItemEntity item, Integer quantity) {
        pk = new OrderItemPK();
        pk.setItem(item);
        pk.setOrder(order);
        this.quantity = quantity;
    }

    @Transient
    public ItemEntity getProduct() {
        return this.pk.getItem();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

	public OrderItemPK getPk() {
		return pk;
	}

	public void setPk(OrderItemPK pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
