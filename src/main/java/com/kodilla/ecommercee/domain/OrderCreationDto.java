package com.kodilla.ecommercee.domain;

public class OrderCreationDto {
    private Long userId;
    private Long cartId;

    public OrderCreationDto(Long userId, Long cartId) {
        this.userId = userId;
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCartId() {
        return cartId;
    }
}
