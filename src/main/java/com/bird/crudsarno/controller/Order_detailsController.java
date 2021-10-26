package com.bird.crudsarno.controller;

import com.bird.crudsarno.entity.Order_details;
import com.bird.crudsarno.service.Order_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Order_details")
public class Order_detailsController {

    @Autowired
    private Order_detailsService service;

    @PostMapping("/addOrder_details")
    public Order_details addOrder_details(@RequestBody Order_details order_details) {
        return service.saveOrder_details(order_details);
    }

    @GetMapping("/getOrder_details")
    public List<Order_details> getOrder_details() {
        return service.getOrder_details();
    }
}
