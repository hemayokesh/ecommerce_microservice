package com.springboot.product.springbootproduct;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.product.springbootproduct.dto.InventoryDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository ;
    private final InventoryClient inventoryClient ;
    public List<InventoryDto> getProductAvailability(String skuCode) {
        List<InventoryDto> inventoryList = inventoryClient.getStock(skuCode);

        if (inventoryList == null || inventoryList.isEmpty()) {
            throw new ProductNotFoundException("Inventory not found for SKU: " + skuCode);
        }

        return inventoryList;
    }



    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }
    
    

}
