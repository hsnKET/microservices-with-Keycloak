package me.ketlas.orderservice.web;


import me.ketlas.orderservice.entities.Order;
import me.ketlas.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Oder wit ID \"%d\" not found!",id)));
    }
}
