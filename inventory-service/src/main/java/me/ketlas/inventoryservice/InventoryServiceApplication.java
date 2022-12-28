package me.ketlas.inventoryservice;


import me.ketlas.inventoryservice.entities.Product;
import me.ketlas.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;


@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            IntStream.rangeClosed(1,100).forEach(num ->{
                productRepository.save(Product.builder()
                                .name("product ".concat(String.valueOf(num)))
                                .price(Math.random() * 1000)
                                .quantity((int)(Math.random() * 10))
                                .build());
            });
        };
    }
}
