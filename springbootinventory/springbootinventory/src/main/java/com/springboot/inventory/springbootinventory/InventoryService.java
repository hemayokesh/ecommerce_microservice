package com.springboot.inventory.springbootinventory;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	
	 private final InventoryRepository inventoryRepository;

	    public boolean isInStock(String skuCode) {
	        List<InventoryEntity> inventorydata=inventoryRepository.findBySkuCode(skuCode);
	        int length=inventorydata.size();
	        if((length)>0) {
	        	return true;
	        	
	        }
	        else {
	        	return false;
	        }

	    }
	    public List<InventoryEntity> getStock(String skuCode) {
	        List<InventoryEntity> stockList = inventoryRepository.findBySkuCode(skuCode);

	        if (stockList == null || stockList.isEmpty()) {
	            throw new ProductNotFoundException("No inventory found for SKU Code: " + skuCode);
	        }

	        return stockList;
	    }
	}

