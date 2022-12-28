package me.ketlas.orderservice;

import feign.Logger;
import me.ketlas.orderservice.entities.Order;
import me.ketlas.orderservice.entities.ProductItem;
import me.ketlas.orderservice.enums.OrderStatus;
import me.ketlas.orderservice.model.Customer;
import me.ketlas.orderservice.model.Product;
import me.ketlas.orderservice.repositories.OrderRepository;
import me.ketlas.orderservice.repositories.ProductItemRepository;
import me.ketlas.orderservice.services.CustomerRestClientService;
import me.ketlas.orderservice.services.ProductRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class,args);
    }

    @Bean
    CommandLineRunner start(OrderRepository orderRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClientService customerRestClientService,
                            ProductRestClientService productRestClientService){
        return args -> {
            List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
            List<Product> products = productRestClientService.allProducts().getContent().stream().toList();
            Random random = new Random();
            OrderStatus[] statuses = new OrderStatus[]{OrderStatus.CANCELED,OrderStatus.CREATED,
                                                       OrderStatus.DELIVERED,OrderStatus.PENDING};
            IntStream.rangeClosed(0,100)
                    .forEach(i ->{
                        final Order order = orderRepository.save(Order.builder()
                                .createdAt(new Date())
                                .status(statuses[random.nextInt(statuses.length)])
                                .customerId(customers.get(random.nextInt(customers.size())).getId())
                                .build());

                        IntStream.rangeClosed(0,random.nextInt(20))
                                .forEach(j ->{
                                    ProductItem  productItem = ProductItem.builder()
                                                .order(order)
                                                .discount((int)(Math.random()*100))
                                                .quantity(random.nextInt(10))
                                                .price(random.nextInt(1000))
                                                .productId(products.get(random.nextInt(products.size())).getId())
                                                .build();
                                    productItemRepository.save(productItem);
                                });
                    });
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
