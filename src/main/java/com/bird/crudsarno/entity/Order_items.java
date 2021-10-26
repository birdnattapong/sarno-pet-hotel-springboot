package com.bird.crudsarno.entity;

import javax.persistence.*;

@Entity
@Table(name= "order_items")
public class Order_items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order_id;
    private int product_id;
    private int qty;

    public Order_items() { }

    public Order_items(int order_id, int product_id, int qty) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
