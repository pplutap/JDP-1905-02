package com.kodilla.ecommercee.domain;

import com.opencsv.bean.CsvBindByPosition;

public class ProductDto {
    @CsvBindByPosition(position = 0, required = true)
    private String name;
    @CsvBindByPosition(position = 1, required = true)
    private String description;
    @CsvBindByPosition(position = 2, required = true)
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
