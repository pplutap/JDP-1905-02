package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartProductAdderDto {
    private Long id;
    private List<Product> products;

    public CartProductAdderDto(){}

    public CartProductAdderDto(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }
}
