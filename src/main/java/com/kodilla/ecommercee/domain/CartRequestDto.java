package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartRequestDto {
    private RequestType requestType;
    private Long cartId;
    private List<Long> productsId;

    public CartRequestDto(RequestType requestType, Long cartId, List<Long> productsId) {
        this.requestType = requestType;
        this.cartId = cartId;
        this.productsId = productsId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }
}
