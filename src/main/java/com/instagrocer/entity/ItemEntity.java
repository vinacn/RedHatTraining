package com.instagrocer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="items")
public class ItemEntity {
	public ItemEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemid")
	private int itemId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="qty")
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name="qty_date")
	private Date quantityDate;

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

	public ItemEntity(int itemId, String title, String type, String description, double price, int quantity,
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
		return "ItemEntity [itemId=" + itemId + ", title=" + title + ", type=" + type + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", quantityDate=" + quantityDate + "]";
	}
	
}
