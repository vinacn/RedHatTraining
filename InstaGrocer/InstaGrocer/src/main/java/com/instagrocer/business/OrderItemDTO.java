package com.instagrocer.business;
import com.instagrocer.entity.ItemEntity;

public class OrderItemDTO {
	private ItemEntity item;
    private Integer quantity;

    public ItemEntity getProduct() {
        return item;
    }

    public void setProduct(ItemEntity item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
