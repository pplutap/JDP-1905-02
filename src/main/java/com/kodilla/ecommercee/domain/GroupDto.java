package com.kodilla.ecommercee.domain;

import java.util.List;

public class GroupDto {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> products;

    public GroupDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public GroupDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
