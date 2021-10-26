package com.bird.crudsarno.repository;

import com.bird.crudsarno.entity.Bill;
import com.bird.crudsarno.entity.Order_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Order_itemsRepository extends JpaRepository<Order_items, Integer> {
    @Query(value = "SELECT productName, qty , sellPrice " +
            "FROM order_items, product " +
            "WHERE order_items.product_id = product.id " +
            "AND order_items.order_id = ?1", nativeQuery = true)
    List<Bill> findBill(int order_id);
}
