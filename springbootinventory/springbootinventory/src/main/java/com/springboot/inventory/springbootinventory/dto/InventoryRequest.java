package com.springboot.inventory.springbootinventory.dto;

import lombok.Data;

@Data
public class InventoryRequest {
	private String skuCode;
    private int quantity;
    private int stock;
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
    
}
