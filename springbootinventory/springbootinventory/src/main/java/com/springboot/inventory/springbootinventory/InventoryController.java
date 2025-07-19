package com.springboot.inventory.springbootinventory;

import java.util.Collections;
import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.inventory.springbootinventory.dto.InventoryRequest;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

	
	private final InventoryService inventoryService;
	private final InventoryRepository inventoryRepository;
	
	public InventoryController(InventoryService inventoryService, InventoryRepository inventoryRepository) {
	    this.inventoryService = inventoryService;
	    this.inventoryRepository = inventoryRepository;
	}

    @GetMapping("/{skuCode}")
    public ResponseEntity<?> getStock(@PathVariable String skuCode) {
//    	List<InventoryEntity> products = inventoryService.getStock(skuCode);
//        return ResponseEntity.ok(products);
try {
            
            List<InventoryEntity> products = inventoryService.getStock(skuCode);
            return ResponseEntity.ok(products);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
	}
    @PostMapping
    public ResponseEntity<InventoryEntity> createInventory(@RequestBody InventoryRequest request) {
        InventoryEntity entity = new InventoryEntity();
        entity.setSkuCode(request.getSkuCode());
        entity.setQuantity(request.getQuantity());
        entity.setStock(request.getStock());


        InventoryEntity saved = inventoryRepository.save(entity);
        return ResponseEntity.status(201).body(saved);
    }

}