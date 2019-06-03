package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartProductAdderDto {
    private Long cartId;
    private List<Product> products;

    public CartProductAdderDto(){}

    public CartProductAdderDto(Long cartId, List<Product> products) {
        this.cartId = cartId;
        this.products = products;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<Product> getProducts() {
        return products;
    }
}
