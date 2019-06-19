package com.kodilla.ecommercee.domain;

public class CartProductDeleterDto {
    private Long id;
    private Long productId;

    public CartProductDeleterDto(){}

    public CartProductDeleterDto(Long id, Long productId) {
        this.id = id;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }
}
