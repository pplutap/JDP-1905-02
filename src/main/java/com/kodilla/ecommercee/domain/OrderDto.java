package com.kodilla.ecommercee.domain;

import java.util.List;

public class OrderDto {
    private Long id;
    private String user;
    private List<Long> cart;

    public OrderDto(Long id, String user, List<Long> cart) {
        this.id = id;
        this.user = user;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public List<Long> getCart() {
        return cart;
    }
}