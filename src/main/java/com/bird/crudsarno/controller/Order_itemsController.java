package com.bird.crudsarno.controller;

import com.bird.crudsarno.entity.Bill;
import com.bird.crudsarno.entity.Order_items;
import com.bird.crudsarno.service.Order_itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Order_items")
public class Order_itemsController {

    @Autowired
    private Order_itemsService service;

    @Autowired
    private ProductController productController;

    @PostMapping("/addOrder_items")
    public List<Order_items> addOrder_items(@RequestBody List<Order_items> order_items) {
        for(int i=0; i<order_items.toArray().length; i++) {
            productController.sellProduct(order_items.get(i).getProduct_id(), order_items.get(i).getQty());
        }
        return service.saveOrder_items(order_items);
    }

    @GetMapping("/getBill/{order_id}")
    public List<Bill> getBill(@PathVariable int order_id) {
        return service.findBill(order_id);
    }
}
