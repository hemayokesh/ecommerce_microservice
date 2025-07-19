package com.springboot.inventory.springbootinventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeController {

	@GetMapping("/helloinventory")
    public String sayHello() {
        return "Hello, inventory!";
    }
}
