package com.kodilla.ecommercee.domain;

public class OrderDto {
    private Long id;
    private User user;
    private Cart cart;

    public OrderDto(Long id, User user, Cart cart) {
        this.id = id;
        this.user = user;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }
}
