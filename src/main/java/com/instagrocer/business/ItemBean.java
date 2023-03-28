package com.instagrocer.business;
import java.util.Date;
public class ItemBean {	
	private int itemId;
	private String title;
	private String type;
	private String description;
	private double price;
	private int quantity;
	private Date quantityDate;
	public ItemBean() {
		
	}
	public ItemBean(int itemId, String title, String type, String description, double price, int quantity,
			Date quantityDate) {
		super();
		this.itemId = itemId;
		this.title = title;
		this.type = type;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.quantityDate = quantityDate;
	}
	@Override
	public String toString() {
		return "ItemBean [itemId=" + itemId + ", title=" + title + ", type=" + type + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", quantityDate=" + quantityDate + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getQuantityDate() {
		return quantityDate;
	}
	public void setQuantityDate(Date quantityDate) {
		this.quantityDate = quantityDate;
	}
}
