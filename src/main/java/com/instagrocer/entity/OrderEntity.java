package com.instagrocer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="items")
public class OrderEntity {
	
	
	public OrderEntity() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderid")
	private int orderId;
	
	@Column(name="user")
	private String user;
	
	@Column(name="amount")
	private double amount;
	
    @OneToMany(mappedBy = "pk.order")
	@Valid
	private List<OrderItem> items = new ArrayList<>();;
	
	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="delivery_status")
	private String deliveryStatus;
		
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public OrderEntity(int orderId, String user, double amount,List<OrderItem> items) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.amount = amount;
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", user=" + user + ", amount=" + amount + "]";
	}
	
}
