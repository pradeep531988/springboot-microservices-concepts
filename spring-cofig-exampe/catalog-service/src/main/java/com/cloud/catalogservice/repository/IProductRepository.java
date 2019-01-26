package com.cloud.catalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloud.catalogservice.model.Product;
import java.util.Optional;
 
public interface IProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
}
