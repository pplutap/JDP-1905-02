package com.kodilla.ecommercee.domain;

public class CartDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String groupId;

    public CartDto() {
    }

    public CartDto(Long id, String name, String description, double price, String groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
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

    public double getPrice() {
        return price;
    }

    public String getGroupId() {
        return groupId;
    }
}
