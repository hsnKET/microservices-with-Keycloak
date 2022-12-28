package me.ketlas.inventoryservice.web;


import me.ketlas.inventoryservice.entities.Product;
import me.ketlas.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

   /* @GetMapping("/products")
    public List<Product> allProducts(){
        return productRepository.findAll();
    }*/
}
