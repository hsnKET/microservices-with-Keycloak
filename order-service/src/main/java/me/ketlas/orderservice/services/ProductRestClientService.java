package me.ketlas.orderservice.services;

import me.ketlas.orderservice.model.Customer;
import me.ketlas.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClientService {

    @GetMapping("/products/{id}?projection=fullProduct")
    Product productById(@PathVariable Long id);

    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> allProducts();

}
