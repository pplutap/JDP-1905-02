package com.kodilla.ecommercee.domain;

public class CartDto {
    private Long cartId;
    private String groupId;

    public CartDto() {
    }

    public CartDto(Long cartId,String groupId) {
        this.cartId = cartId;
        this.groupId = groupId;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getGroupId() {
        return groupId;
    }
}
