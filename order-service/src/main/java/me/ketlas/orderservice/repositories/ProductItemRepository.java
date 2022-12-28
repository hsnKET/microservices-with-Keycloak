package me.ketlas.orderservice.repositories;

import me.ketlas.orderservice.entities.Order;
import me.ketlas.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
