package com.kodilla.ecommercee.domain;

import java.util.List;

public class GroupDto {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> products;

    public GroupDto(Long id, String name, String description, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
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
