package com.bird.crudsarno.service;

import com.bird.crudsarno.entity.Bill;
import com.bird.crudsarno.entity.Order_items;
import com.bird.crudsarno.repository.Order_itemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_itemsService {

    @Autowired
    private Order_itemsRepository repository;

    public List<Order_items> saveOrder_items(List<Order_items> order_items) {
        return repository.saveAll(order_items);
    }

    public List<Bill> findBill(int order_id) {
        return repository.findBill(order_id);
    }
}
