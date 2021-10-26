package com.bird.crudsarno.entity;

import javax.persistence.*;

@Entity
@Table(name= "order_details")
public class Order_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int total;
    private String payment;
    private String created_at;

    public Order_details() { }

    public Order_details(int total, String payment, String created_at) {
        this.total = total;
        this.payment = payment;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
