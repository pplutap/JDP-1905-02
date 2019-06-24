package com.kodilla.ecommercee.domain;

import java.util.List;

public class OrderDto {
    private Long id;
    private String user;
    private String orderProducts;

    public OrderDto(){}

    public OrderDto(Long id, String user, String products) {
        this.id = id;
        this.user = user;
        this.orderProducts = products;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getOrderProducts() {
        return orderProducts;
    }
}