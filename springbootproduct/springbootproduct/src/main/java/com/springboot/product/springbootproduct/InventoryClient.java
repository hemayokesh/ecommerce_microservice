package com.springboot.product.springbootproduct;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.product.springbootproduct.dto.InventoryDto;


@FeignClient(name = "inventory-service", path = "/api/inventory")
public interface InventoryClient {
    @GetMapping("/{skuCode}")
    List<InventoryDto> getStock(@PathVariable String skuCode);
}

