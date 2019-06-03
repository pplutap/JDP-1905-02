package com.kodilla.ecommercee.domain;

public class CartProductDeleterDto {
    private Long cartId;
    private Long productId;

    public CartProductDeleterDto(){}

    public CartProductDeleterDto(Long cartId, Long productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getProductId() {
        return productId;
    }
}
