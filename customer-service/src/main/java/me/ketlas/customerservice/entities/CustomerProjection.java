package me.ketlas.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Projection(name = "fullCustomer",types = Customer.class)
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
}
