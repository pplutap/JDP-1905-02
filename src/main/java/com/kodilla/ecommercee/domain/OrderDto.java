package com.kodilla.ecommercee.domain;

import java.util.List;

public class OrderDto {
    private Long id;
    private String user;
    private List<Long> products;

    public OrderDto(){}

    public OrderDto(Long id, String user, List<Long> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public List<Long> getProducts() {
        return products;
    }
}