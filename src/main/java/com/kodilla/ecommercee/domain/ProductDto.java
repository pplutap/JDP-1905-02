package com.kodilla.ecommercee.domain;

public class ProductDto {
    private String name;
    private String description;
    private double price;

    public ProductDto() {}

    public ProductDto(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
}
