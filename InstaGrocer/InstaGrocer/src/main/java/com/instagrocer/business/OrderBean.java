package com.instagrocer.business;

import java.util.List;
public class OrderBean {
	
	private int orderId;
	private String user;
	private double amount;
	private List<ItemBean> items;
	
	public OrderBean() {
		
	}
	
	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", user=" + user + ", amount=" + amount + ", items=" + items + "]";
	}
	public OrderBean(int orderId, String user, double amount, List<ItemBean> items) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.amount = amount;
		this.items = items;
	}
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
	public List<ItemBean> getItems() {
		return items;
	}
	public void setItems(List<ItemBean> items) {
		this.items = items;
	}
}
