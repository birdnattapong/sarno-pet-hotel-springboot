package com.bird.crudsarno.repository;

import com.bird.crudsarno.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product WHERE remain < product.stock/3", nativeQuery = true)
    List<Product> getAlmostEmptyProducts();
}
