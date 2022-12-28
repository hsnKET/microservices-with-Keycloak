package me.ketlas.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ketlas.orderservice.enums.OrderStatus;
import me.ketlas.orderservice.model.Customer;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Projection(types = {Order.class}, name = "fullOrder")
public interface OrderProjection {

    Long getId();
    Date getCreatedAt();
    OrderStatus getStatus();
    Long getCustomerId();
}
