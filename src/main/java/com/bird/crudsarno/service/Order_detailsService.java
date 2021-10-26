package com.bird.crudsarno.service;

import com.bird.crudsarno.entity.Order_details;
import com.bird.crudsarno.repository.Order_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_detailsService {

    @Autowired
    private Order_detailsRepository repository;

    public Order_details saveOrder_details(Order_details order_details) {
        return repository.save(order_details);
    }

    public List<Order_details> getOrder_details() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
