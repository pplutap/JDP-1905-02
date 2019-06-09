package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartDto {
    private Long cartId;
    private String groupId;
    private List<Product> products;

    public CartDto() {
    }

    public CartDto(List<Product> products) {
        this.products = products;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getGroupId() {
        return groupId;
    }
}
