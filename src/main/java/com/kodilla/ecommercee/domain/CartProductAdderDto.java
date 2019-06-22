package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartProductAdderDto {

    private Long id;

    private List<ProductDto> productsDto;

    private Long group;

    public CartProductAdderDto(){}

    public CartProductAdderDto(Long id, List<ProductDto> productsDto) {
        this.id = id;
        this.productsDto = productsDto;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProductsDto() {
        return productsDto;
    }

    public Long getGroup() {
        return group;
    }
}
